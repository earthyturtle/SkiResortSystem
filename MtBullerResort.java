package mtbuller;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import mtbuller.Accommodation.accomType;
import mtbuller.Customer.experience;
import mtbuller.TravelPackage.liftPassValues;

public class MtBullerResort {
	static Scanner input = new Scanner(System.in);
	private FileInputStream fileIn;
	private ObjectInputStream objectIn;
	private FileOutputStream fileOut;
	private ObjectOutputStream objectOut;
	private ArrayList<Accommodation> accommodations;
	private ArrayList<Customer> customers;
	private ArrayList<TravelPackage> travelPackages;

	public MtBullerResort() {
		accommodations = new ArrayList<Accommodation>();
	    customers = new ArrayList<Customer>();
	    travelPackages = new ArrayList<TravelPackage>();
	}
	
	public void startup() {
		System.out.println("Initiating...");
		try{
			Accommodation[] arrayAccom = {
				new Accommodation("Eastside Lodge", "Quiet lodge on the east side of the mountian.", accomType.LODGE, 249.99, true, true, true, false, true), 
				new Accommodation("Kabuki Mt Buller", "Guesthouses with private rooms with Ensuites.", accomType.LODGE, 126.00, true, true, false, true, true), 
				new Accommodation("Alzburg Resort", "Nested In Mansfield, picturesque Victorian high country.", accomType.APARTMENT, 150, false, false, true, true, true), 
				new Accommodation("Enzian Hotel", "Beautiful hotels found on the west side.", accomType.HOTEL, 189.99, true, false, true, true, true), 
				new Accommodation("Vaugthon Lodging", "A stunning nordic style lodge.", accomType.LODGE, 200, true, true, true, true, false), 
				new Accommodation("Riverside Hotel", "Down in the valley within 20 minutes drive of Mt Buller.", accomType.HOTEL, 178, false, false, true, true, true), 
				new Accommodation("Blue Star", "Gorgeous 5 star hotel in Mansfield.", accomType.HOTEL, 223, false, false, true, true, true), 
				new Accommodation("High Country", "A set of apartments on the lower end of the Mountain.", accomType.APARTMENT, 100, true, false, true, false, true), 
				new Accommodation("Snowy Peak", "Housign found just outside the hot tourist areas.", accomType.LODGE, 120, true, true, true, false, false), 
				new Accommodation("Olympus Heights", "A high altitude, high class accomodation.", accomType.HOTEL, 321, true, true, false, true, true)
			};
			for(int a = 0; a < arrayAccom.length; a++) {
				accommodations.add(arrayAccom[a]);
			}
			System.out.println("10 Accomodation Objects Added Successfully");
		}
		catch (Exception e){
		System.out.println("  !- Error: Accomodation Arraylist hit an unexpected error -!");
		}
		try{{
			Customer[] arrayCust = {
					new Customer("Jane", "Doe", (byte) 20, experience.INTERMEDIATE, "0451413121", "jane.doe@gmail.com"), 
					new Customer("Kace", "Mirada", (byte) 28, experience.BEGINNER, "59838481", "kace.vv.2020@gmail.com"), 
					new Customer("Marty", "McTurtle", (byte) 45, experience.EXPERT, "59778866", "turtle_time@bigpond.com")
				};
				for(int c = 0; c < arrayCust.length; c++) {
					customers.add(arrayCust[c]);
				}
			}
			System.out.println("3 Customer Objects Added Successfully");
		}
		catch (Exception e){
			System.out.println("  !- Error: Customer Arraylist hit an unexpected error -!");
		}
	}
	
	public void run() {
		int main_menu = 0;
		while(main_menu != 11) {
			System.out.print("|==== Mount Buller Admin Panel ====| \r\n" +
					"      1: Display all accommodations    \r\n" + 
					"      2: Display available accommodations              \r\n" + 
					"      3: Add customer     \r\n" + 
					"      4: List customers          \r\n" + 
					"      5: Create a package \r\n" + 
					"      6: Add a lift pass to package \r\n" + 
					"      7: Add lesson fees to package\r\n" + 
					"      8:  List packages  \r\n" + 
					"      9:  Save packages to file    \r\n" + 
					"      10: Read packages from file \r\n" + 
					"      11: Quit\r\n" + 
					"Number Selecion: ");
			try {
				clearScanner();
				main_menu = input.nextInt();
			}
			catch(Exception e) {
				main_menu = 0;
			}
			refresh_page();
			switch(main_menu) {
			case 1:
				System.out.println("Display all accommodations");
				showAllAccom();
				break;
			case 2:
				System.out.println("Display available accommodations");
				showAvailableAccom();
				break;
			case 3:
				System.out.println("Add customer");
				addCustomer();
				break;
			case 4:
				System.out.println("List customers");
				showAllCust();
				break;
			case 5:
				System.out.println("Create a package");
				addPackage();
				break;
			case 6:
				System.out.println("Add a lift pass to package");
				addLiftPass();
				break;
			case 7:
				System.out.println("Add lesson fees to package");
				addLessons();
				break;
			case 8:
				System.out.println("List packages");
				showAllPack();
				break;
			case 9:
				System.out.println("Saving packages to file");
				savePackages();
				break;
			case 10:
				System.out.println("Reading packages from file");
				readPackages();
				break;
			case 11:
				break;
			default:
				System.out.println("  !- ERROR: Not a valid input, please select a number from the menu. -!");
				break;
			}
			if (main_menu != 11) {
				pressEnter();
				refresh_page();
			}
		}
	}
	  
    
	public void savePackages() {
		try {
			fileOut = new FileOutputStream("packages.dat");
			objectOut = new ObjectOutputStream(fileOut);
			for (TravelPackage p:travelPackages) {
				objectOut.writeObject(p);
			}
			fileOut.close();
			objectOut.close();
		} 
		catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	 
	public void readPackages() {
		travelPackages.clear();
		try {
			fileIn = new FileInputStream("packages.dat");
			objectIn = new ObjectInputStream(fileIn);
			while (true) {
		        try {
		        	Object object = objectIn.readObject();
		        	TravelPackage p = (TravelPackage)object;
		        	int roomNo = p.getAccomID();
		        	Accommodation a = searchAccomID(roomNo);
		        	a.setAvailable(false);
		        	travelPackages.add(p);
		        	System.out.println(p);
		        }
		        catch (EOFException eof) {
		        	fileIn.close();
		        	objectIn.close();
		        	break;
		        }
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//menu options
	public void showAllAccom() {
	    for (Accommodation a:accommodations) {
		    System.out.println(a.toString());
	    }
	}

	public void showAvailableAccom() {
		for (Accommodation a:accommodations) {
			if (a.isAvailable() == true) {
				System.out.println(a);
			}
	    }
	}
	
	public void addCustomer() {
		boolean check = false;
		System.out.print("What is the customer's first name? ");
		clearScanner();
	    String fname = input.nextLine();
		System.out.print("what is the customer's last name? ");
		clearScanner();
	    String lname = input.nextLine();
	    byte age = 0;
	    do {
	    	check = false;
		    try {
				clearScanner();
				System.out.print("What is the customer's age? ");
				byte selection = input.nextByte();
			    if (selection <= 127 && selection >= 18) {
			    	age = selection;
			    	check = true;
			    }
			    else
			    {
			    	System.out.println("  !- ERROR: Customer must be between the ages of 18 and 127. -!");
			    }
		    }
		    catch (Exception e) {
				System.out.println("  !- ERROR: Not a valid input, please input a valid response with only numbers. -!");
		    }
	    } while (check == false);
	    experience experience = Customer.experience.BEGINNER;
	    do {
	    	check = false;
			System.out.println("How experienced at skiing/snowboarding is the customer? ");
			System.out.println("1: BEGINNER");
			System.out.println("2: INTERMEDIATE");
			System.out.println("3: EXPERT");
			System.out.print("Number: ");
			clearScanner();
		    String selection = input.nextLine();
		    if (selection.equals("1") || selection.equalsIgnoreCase("BEGINNER")) {
		    	experience = Customer.experience.BEGINNER;
		    	check = true;
		    }
		    else if (selection.equals("2") || selection.equalsIgnoreCase("INTERMEDIATE")) {
		    	experience = Customer.experience.INTERMEDIATE;
		    	check = true;
		    }
		    else if (selection.equals("3") || selection.equalsIgnoreCase("EXPERT")) {
		    	experience = Customer.experience.EXPERT;
		    	check = true;
		    }
		    else {
				System.out.println("  !- ERROR: Not a valid input, please select a number or name from the menu. -!");
		    }
	    } while (check == false);
	    String phone = "00000000";
	    do {
			System.out.print("What is the customer's phone number? ");
	    	try {
				clearScanner();
	    		phone = input.nextLine();
		    	check = isNumeric(phone);
	    	}
	    	catch (Exception e) {
				System.out.println("  !- ERROR: Not a valid input, please input a valid response with only numbers. -!");
	    	}
	    } while (check == false);
		System.out.print("What is the customer's email address? ");
		clearScanner();
	    String email = input.nextLine();
	    customers.add(new Customer(fname, lname, age, experience, phone, email));
		System.out.println("New customer " + fname + ", " + lname + " added to the database.");
	}
	
	public void showAllCust() {
		for (Customer c:customers) {
		    System.out.println(c.toString());
		}
	}
	
	public void addPackage() {
		boolean check = false;
		int custID = 0;
		int accomID = 0;
		LocalDate arrival = null;
		LocalDate departure = null;
		do {
	    	System.out.print("Please provide the Customer ID associated with this Package: ");
			check = false;
			try {
				clearScanner();
			    int selection = input.nextInt();
			    for (Customer c: customers) {
		             if (c.getCustID() == selection) {
		            	 check = true;
		            	 break;
		             }
		         }
			}
			catch (Exception e) {
				System.out.println("  !- ERROR: Customer not found, please input a valid response. -!");
			}
		} while(check == false);
		accomID = addAccommodation();
		do {
			LocalDate today = LocalDate.now();
			check = false;
			try {
				System.out.print("What date does the customer want to check in?  (YYYY-MM-DD) ");
				clearScanner();
				LocalDate date = LocalDate.parse(input.nextLine());
				if (date.isAfter(today) || date.isEqual(today)) {
				    arrival = date;
					check = true;
				}
				else {
					System.out.println("  !- ERROR: Cannot have a arrival date pre-dating today. -!");
				}
			}
			catch (Exception e) {
				System.out.println("  !- ERROR: invalid input or format, follow the YYYY-MM-DD including any leading 0's. -!");
			}
		} while (check == false);
		do {
			check = false;
			try {
				System.out.print("What date does the customer want to check out?  (YYYY-MM-DD) ");
				clearScanner();
				LocalDate date = LocalDate.parse(input.nextLine());
				if (date.isAfter(arrival)) {
					departure = date;
					check = true;
				}
				else {
					System.out.println("  !- ERROR: Cannot have a departure date pre-dating the arrival date. -!");
				}
			}
			catch (Exception e) {
				System.out.println("  !- ERROR: invalid input or format, follow the YYYY-MM-DD including any leading 0's. -!");
			}
		} while (check == false);
		travelPackages.add(new TravelPackage(custID, accomID, arrival, departure));
		System.out.println("New package created.");
	}
	
	public void showAllPack() {
		for (TravelPackage p:travelPackages) {
		    System.out.println(p.toString());
		}
	}
	
	public void addLiftPass() {
		boolean check = false;
		do {
			check = false;
			try {
			    System.out.println("Which package would you like to add a lift pass too? Please provide the package ID: ");
				clearScanner();
				int selection = input.nextInt();
				for (TravelPackage p:travelPackages) {
					if(p.getPackID() == selection) {
						System.out.println("How many days would the customer like to book access for?");
						System.out.println("0: no pass");
						System.out.println("1: 1 day = $26");
						System.out.println("2: 5 days = $117");
						System.out.println("3: Season pass = $200");
						System.out.print("Selection Number (0-3): ");
						clearScanner();
						String pass = input.nextLine();
						if (pass.equals("0")) {
							p.setLiftPass(liftPassValues.NOPASS);
							check = true;
							System.out.println("No pass added to Package.");
						}
						else if (pass.equals("1")) {
							p.setLiftPass(liftPassValues.DAYPASS);
							check = true;
							System.out.println("Full day pass added to Package.");
						}
						else if (pass.equals("2")) {
							p.setLiftPass(liftPassValues.FIVEDAY);
							check = true;
							System.out.println("Five Day pass added to Package.");
						}
						else if (pass.equals("3")) {
							p.setLiftPass(liftPassValues.SEASON);
							check = true;
							System.out.println("Season pass added to Package.");
						}
						else {
							System.out.println("  !- ERROR: Not a valid number, please input a number from 0 to 3. -!");
						}
					}
					break;
				}
			}
			catch (Exception e) {
				System.out.println("  !- ERROR: Not a valid input, please provide the Package ID number. -!");
			}
		} while (check == false);
	}
	
	public void addLessons() {
		boolean check = false;
		do {
			check = false;
			try {
			    System.out.println("Which package would you like to add lessons too? Please provide the package ID: ");
				clearScanner();
				int selection = input.nextInt();
				for (TravelPackage p:travelPackages) {
					if(p.getPackID() == selection) {
						try {
							System.out.println("How many lessons would the customer like to book for?");
							clearScanner();
							p.setLessons(input.nextInt());
							check = true;
							System.out.println("Lessons added to Package.");
						}
						catch (Exception e) {
							System.out.println("  !- ERROR: Not a valid input, please provide a number for lessons in the package. -!");
						}
					}
					break;
				}
			}
			catch (Exception e) {
				System.out.println("  !- ERROR: Not a valid input, please provide the Package ID number. -!");
			}
		} while (check == false);
	}
	
//MISC methods
	public Accommodation searchAccomID(int accomID){
		for(Accommodation a: accommodations){
			if(a.getAccomID() == accomID)
				return a;
		}
		return null;
	}
	  
	public int addAccommodation() {
		boolean check = false;
		int accomID = 0;
		do {
			check = false;
	    	System.out.println("Why type of accomodation does the customer want?");
			System.out.println("1: HOTEL");
			System.out.println("2: LODGE");
			System.out.println("3: APARTMENT");
			System.out.print("Number: ");
			clearScanner();
		    String selection = input.nextLine();
		    accomType memory = null;
		    if (selection.equals("1") || selection.equalsIgnoreCase("HOTEL")) {
		    	memory = Accommodation.accomType.HOTEL;
		    }
		    else if (selection.equals("2") || selection.equalsIgnoreCase("LODGE")) {
		    	memory = Accommodation.accomType.LODGE;
		    }
		    else if (selection.equals("3") || selection.equalsIgnoreCase("APARTMENT")) {
		    	memory = Accommodation.accomType.APARTMENT;
		    }
		    else {
				System.out.println("  !- ERROR: Not a valid input, please select a number or name from the menu. -!");
		    }
	    	if (memory != null) {
	    	    for (Accommodation a: accommodations) {
	    	    	if (a.getType().equals(memory) && a.isAvailable() == true) {
	    				System.out.println(a);
	    	    	}
	    	    }
		    	System.out.print("Please provide the Accomodation ID number: ");
				try {
					clearScanner();
				    int id = input.nextInt();
				    for (Accommodation a: accommodations) {
				    	if (a.getAccomID() == id && a.isAvailable() == true) {
				    		a.setAvailable(false);
				    		accomID = a.getAccomID();
				    		break;
				    	}
				    }
		    		check = true;
				}
				catch (Exception e) {
					System.out.println("  !- ERROR: Accomodation not available, please provide the ID number of an available Accomodation. -!");
				}
	    	}
		} while(check == false);
		return accomID;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int n = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static void refresh_page() {
		for (int i = 0; i < 6; i++)
		{
			System.out.println("");
		}
	}
	
	public static void pressEnter() {
    	System.out.print("Press Enter to continue");
		clearScanner();
		input.nextLine();
	}
	
	public static void clearScanner() {
        if (input != null) {
        	input = new Scanner(System.in);
        }
    }
	
	public void close() {
		for (int i = 0; i < 3; i++)
		{
			System.out.println("");
		}
		System.out.println("              Exiting program. Have a nice day! :)");
		for (int i = 0; i < 3; i++)
		{
			System.out.println("");
		}
		
	}
}
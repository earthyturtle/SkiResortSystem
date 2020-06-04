package mtbuller;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

/*
 * I think I turned the Database into an object. I hope that i did because that was my intention to completely utilise the power of Java's Object Orientation.
 * I wanted to point out that separating the Database was a deliberate choice to help make the code more legible. Doing this will hopefully make the
 * code easier for other programmers viewing my work. Everything to do with the database, saving and loading is stored here.
 */

public class MtBullerDatabase {
	ArrayList<Accommodation> arrayAccom;
	DefaultListModel<Accommodation> accomListModel = new DefaultListModel<Accommodation>();
	JList <Accommodation> accomList = new JList<Accommodation>(accomListModel);
	JScrollPane accomScroll = new JScrollPane(accomList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	ArrayList<Customer> arrayCust;
	DefaultListModel<Customer> custListModel = new DefaultListModel<Customer>();
	JList <Customer> custList = new JList<Customer>(custListModel);
	JScrollPane custScroll = new JScrollPane(custList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	ArrayList<TravelPackage> arrayPack;
	DefaultListModel<TravelPackage> packListModel = new DefaultListModel<TravelPackage>();
	JList <TravelPackage> packList = new JList<TravelPackage>(packListModel);
	JScrollPane packScroll = new JScrollPane(packList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private FileInputStream fileIn;
	private ObjectInputStream objectIn;
	private FileOutputStream fileOut;
	private ObjectOutputStream objectOut;
	
	// Start-up Functions
	
	public MtBullerDatabase() {
		arrayAccom = new ArrayList<Accommodation>();
		arrayCust = new ArrayList<Customer>();
		arrayPack = new ArrayList<TravelPackage>();
	}
	
	public void loadDatabase() { // The database will actually load any previous files from it's last session on start-up, letting users continue their work.
		boolean accomLoad = false;
		boolean custLoad = false;
		boolean packLoad = false;
		boolean accomReload = false;
		boolean custReload = false;
		boolean packReload = false;
		System.out.println("Initiating: Loading Database..."); // I am decidedly using the print function to help developers using console debug or identify issues within the code. Once exported, this console won't be visible without special permissions.
		try{
			fileIn = new FileInputStream("accommodations.dat"); // I have added save/load functions for all 3 lists. 
			objectIn = new ObjectInputStream(fileIn);
			while (true) {
			    try {
			       	Object object = objectIn.readObject();
			       	Accommodation a = (Accommodation)object;
			    	arrayAccom.add(a);
					accomListModel.addElement(a);
					Accommodation.accomCount.set(a.getAccomID());
					accomLoad = true;
			    }
			    catch (EOFException eof) {
			    	fileIn.close();
			        objectIn.close();
			        break;
			    }
			}
		}
		catch (FileNotFoundException e){ // in the event this is the 'first time' loading, the database will create the files and default objects needed.
			Accommodation[] accommodations = defaultAccommodations();
			for(int a = 0; a < accommodations.length; a++) {
				arrayAccom.add(accommodations[a]);
				accomListModel.addElement(accommodations[a]);
			}
			saveAccommodations(false);
			System.out.println("Missing file: Generating default Accommodation list.");
			accomReload = true;
		}
		catch (InvalidClassException e){ // A fail-safe, in-case the file in question becomes corrupt or is from a different version. The program automatically re-writes it.
			Accommodation[] accommodations = defaultAccommodations();
			for(int a = 0; a < accommodations.length; a++) {
				arrayAccom.add(accommodations[a]);
				accomListModel.addElement(accommodations[a]);
			}
			saveAccommodations(false);
			System.out.println("Corrupt file: Rebuilding Accommodation file.");
			accomReload = true;
		}
		catch (Exception e){ // for any other errors, this system is designed to explain the error occurring and leave it to a developer to find a fix.
			e.printStackTrace();
			System.out.println("Unexpected Error: Accommodation Arraylist could not be loaded.");
			accomReload = true;
		}
		if(accomLoad == true) {
			System.out.println("Success: Loaded Accommodation lists.");
		}
		else if (accomReload == false) {
			System.out.println("Empty File: No Accommodation list loaded.");
		}
		
		try{
			fileIn = new FileInputStream("customers.dat");
			objectIn = new ObjectInputStream(fileIn);
			while (true) {
		        try {
				    Object object = objectIn.readObject();
				    Customer c = (Customer)object;
				    arrayCust.add(c);
					custListModel.addElement(c);
					Customer.custCount.set(c.getCustID());
					custLoad = true;
		        }
		        catch (EOFException eof) {
		        	fileIn.close();
		        	objectIn.close();
		            break;
		        }
			}
		}
		catch (FileNotFoundException e){
			Customer[] customers = defaultCustomers();
			for(int c = 0; c < customers.length; c++) {
				arrayCust.add(customers[c]);
				custListModel.addElement(customers[c]);
			}
			saveCustomers(false);
			System.out.println("Missing file: Generating default Customer list.");
			custReload = true;
		}
		catch (InvalidClassException e){
			Customer[] customers = defaultCustomers();
			for(int c = 0; c < customers.length; c++) {
				arrayCust.add(customers[c]);
				custListModel.addElement(customers[c]);
			}
			saveCustomers(false);
			System.out.println("Corrupt file: Rebuilding Customer file.");
			custReload = true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Unexpected Error: Customer Arraylist could not be loaded.");
			custReload = true;
		}
		if(custLoad == true) {
			System.out.println("Success: Loaded customer lists.");
		}
		else if(custReload == false) {
			System.out.println("Empty File: No Customer list loaded.");
		}
		
		try{
			fileIn = new FileInputStream("packages.dat");
			objectIn = new ObjectInputStream(fileIn);
			while (true) {
				try {
			       	Object object = objectIn.readObject();
			       	TravelPackage p = (TravelPackage)object;
			       	Accommodation accom = p.getAccommodation();
			       	accom.setAvailable(false);
			       	arrayPack.add(p);
					packListModel.addElement(p);
					TravelPackage.packCount.set(p.getPackID());
					packLoad = true;
				}
	    		catch (EOFException eof) {
	    			fileIn.close();
	    			objectIn.close();
		            break;
	    		}
			}
		}
		catch (FileNotFoundException e){
			savePackages(false);
			System.out.println("Missing file: Generating default Travel Package list.");
			packReload = true;
		}
		catch (InvalidClassException e){
			savePackages(false);
			System.out.println("Corrupt file: Rebuilding Travel Packages file.");
			packReload = true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Unexpected Error: Travel Package Arraylist could not be loaded.");
			packReload = true;
		}
		if(packLoad == true) {
			System.out.println("Success: Loaded Travel Package lists.");
		}
		else if (packReload == false){
			System.out.println("Empty File: Travel Package list loaded.");
		}
		System.out.println("Finish: Database Load complete...");
	}
	
	// Default Lists Functions
	
	private Accommodation[] defaultAccommodations() {
		Accommodation[] accommodations = {
				new Accommodation("Eastside Lodge", "Quiet lodge on the east side of the mountian.", ENUMaccomType.LODGE, 249.99, true, true, true, false),
				new Accommodation("Kabuki", "Guesthouses with private rooms with Ensuites.", ENUMaccomType.LODGE, 126.00, true, true, false, true), 
				new Accommodation("Alzburg Resort", "Nested In Mansfield, picturesque Victorian high country.", ENUMaccomType.APARTMENT, 150, false, false, true, true), 
				new Accommodation("Enzian Hotel", "Beautiful hotels found on the west side.", ENUMaccomType.HOTEL, 189.99, true, false, true, true), 
				new Accommodation("Vaugthon Lodging", "A stunning nordic style lodge.", ENUMaccomType.LODGE, 200, true, true, true, true), 
				new Accommodation("Riverside Hotel", "Down in the valley within 20 minutes drive of Mt Buller.", ENUMaccomType.HOTEL, 178, false, false, true, true), 
				new Accommodation("Blue Star", "Gorgeous 5 star hotel in Mansfield.", ENUMaccomType.HOTEL, 223, false, false, true, true), 
				new Accommodation("High Country", "A set of apartments on the lower end of the Mountain.", ENUMaccomType.APARTMENT, 100, true, false, true, false), 
				new Accommodation("Snowy Peak", "Housign found just outside the hot tourist areas.", ENUMaccomType.LODGE, 120, true, true, true, false), 
				new Accommodation("Olympus Heights", "A high altitude, high class accomodation.", ENUMaccomType.HOTEL, 321, true, true, false, true)
			};
		return accommodations;
	}
	
	private Customer[] defaultCustomers() {
			Customer[] customers = {
				new Customer("Jane", "Doe", (byte) 20, ENUMexperience.INTERMEDIATE, "0451413121", "jane.doe@gmail.com"), 
				new Customer("Kace", "Mirada", (byte) 28, ENUMexperience.BEGINNER, "59838481", "kace.vv.2020@gmail.com"), 
				new Customer("Marty", "McTurtle", (byte) 45, ENUMexperience.EXPERT, "59778866", "turtle_time@bigpond.com")
			};
			return customers;
	}
	
	// Save Files Functions
	
	public void saveAll() {
		try {
			saveAccommodations(false);
			saveCustomers(false);
			savePackages(false);
			System.out.println("Success: auto save files. Data was saved.");
			System.out.println("");
			System.out.println("Have a 'turtley' nice day :)");
		}
		catch(Exception e) {
			System.out.println("Error: Unable to auto save files. Data was lost.");
		}
	}
    
	public void saveAccommodations(boolean report) { // To recycle code I am using a simple boolean to return whether or not the save function needs to return a report on it's actions.
		if (report) {
			System.out.println("Initiating: Attempting Accommodations save...");
		}
		try {
			fileOut = new FileOutputStream("accommodations.dat");
			objectOut = new ObjectOutputStream(fileOut);
			for (Accommodation a:arrayAccom) {
				objectOut.writeObject(a);
			}
			fileOut.close();
			objectOut.close();
			if (report) {
				System.out.println("Success: Accommodations saved...");
				JOptionPane.showMessageDialog(null, "Saved to accommodations.dat");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (report) {
				System.out.println("Unexpected Error: Unable to save Accommodations.");
				JOptionPane.showMessageDialog(null, "Could not complete save function");
			}
	    }
	}
	public void saveCustomers(boolean report) {
		if (report) {
			System.out.println("Initiating: Attempting Customers save...");
		}
		try {
			fileOut = new FileOutputStream("customers.dat");
			objectOut = new ObjectOutputStream(fileOut);
			for (Customer c:arrayCust) {
				objectOut.writeObject(c);
			}
			fileOut.close();
			objectOut.close();
			if (report) {
				System.out.println("Success: Customers Saved...");
				JOptionPane.showMessageDialog(null, "Saved to customers.dat");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (report) {
				System.out.println("Unexpected Error: Unable to save Customer.");
				JOptionPane.showMessageDialog(null, "Could not complete save function");
			}
		}
	}
	public void savePackages(boolean report) {
		if (report) {
			System.out.println("Initiating: Attempting Travel Packages save...");
		}
		try {
			fileOut = new FileOutputStream("packages.dat");
			objectOut = new ObjectOutputStream(fileOut);
			for (TravelPackage p:arrayPack) {
				objectOut.writeObject(p);
			}
			fileOut.close();
			objectOut.close();
			if (report) {
				System.out.println("Success: Travel Packages saved...");
				JOptionPane.showMessageDialog(null, "Saved to packages.dat");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (report) {
				System.out.println("Unexpected Error: Unable to save Travel Packages.");
				JOptionPane.showMessageDialog(null, "Could not complete save function");
			}
		}
	}
	
	// Read Files Functions
	 
	public void readAccommodations() {
		System.out.println("Initiating: Attempting to read Accommodations...");
		arrayAccom.clear();
		accomListModel.clear();
		try {
			fileIn = new FileInputStream("accommodations.dat");
			objectIn = new ObjectInputStream(fileIn);
			System.out.println("Success: Accommodations Loaded.");
			while (true) {
		        try {
			       	Object object = objectIn.readObject();
			       	Accommodation a = (Accommodation)object;
			       	arrayAccom.add(a);
					accomListModel.addElement(a);
		        }
		        catch (EOFException eof) {
		        	fileIn.close();
		        	objectIn.close();
					JOptionPane.showMessageDialog(null, "Loaded from accommodations.dat");
		            break;
		        }
			}
		}
		catch (Exception e) {
			System.out.println("Unexpected Error: Unable to load Accommodations.");
			JOptionPane.showMessageDialog(null, "No file found");
		}
	}	 
	public void readCustomers() {
		System.out.println("Initiating: Attempting to read Customers...");
		arrayCust.clear();
		try {
			fileIn = new FileInputStream("customers.dat");
			objectIn = new ObjectInputStream(fileIn);
			System.out.println("Success: Customers Loaded.");
			while (true) {
		        try {
				    Object object = objectIn.readObject();
				    Customer c = (Customer)object;
				    arrayCust.add(c);
					custListModel.addElement(c);
		        }
		        catch (EOFException eof) {
		        	fileIn.close();
		        	objectIn.close();
					JOptionPane.showMessageDialog(null, "Loaded from customers.dat");
		            break;
		        }
			}
		}
		catch (Exception e) {
			System.out.println("Unexpected Error: Unable to load Customers.");
			JOptionPane.showMessageDialog(null, "No file found");
		}
	}
	public void readPackages() {
		System.out.println("Initiating: Attempting to read Travel Packages...");
		arrayPack.clear();
		try {
			fileIn = new FileInputStream("packages.dat");
			objectIn = new ObjectInputStream(fileIn);
			System.out.println("Success: Travel Packages Loaded.");
			while (true) {
				try {
			       	Object object = objectIn.readObject();
			       	TravelPackage p = (TravelPackage)object;
			       	Accommodation accom = p.getAccommodation();
			       	accom.setAvailable(false);
			       	arrayPack.add(p);
					packListModel.addElement(p);
				}
		   		catch (EOFException eof) {
		   			fileIn.close();
		   			objectIn.close();
					JOptionPane.showMessageDialog(null, "Loaded from packages.dat");
		            break;
		   		}
			}
		}
		catch (Exception e) {
			System.out.println("Unexpected Error: Unable to Load Travel Packages.");
			JOptionPane.showMessageDialog(null, "No file found");
		}
	}
			public Accommodation searchAccomID(int accomID){
				for(Accommodation a: arrayAccom){
				if(a.getAccomID() == accomID)
					return a;
				}
				return null;
			}
	
	// Erasing Files Functions
	
	public void eraseAccommodationsFile() { // A little bit extra, if you need to check and see if some of the fail-safes work I included an erase file option.
		try {         
			File f = new File("accommodations.dat");
			f.delete();
			System.out.println("Success: accommodations.dat file deleted...");
			JOptionPane.showMessageDialog(null, "Successfully deleted accommodations.dat file...");
		}
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("Failure: packages.dat file not deleted...");  
		}  
	}
	public void eraseCustomersFile() {
		try {         
			File f= new File("customers.dat");
			f.delete();
			System.out.println("Success: customers.dat file deleted...");
			JOptionPane.showMessageDialog(null, "Successfully deleted packages file...");
		}
		catch(Exception e) {  
			e.printStackTrace();  
			System.out.println("Failure: packages.dat file not deleted...");  
		}  
	}
	public void erasePackagesFile() {
		try {         
			File f= new File("packages.dat");
			f.delete();
			System.out.println("Success: packages.dat file deleted...");
			JOptionPane.showMessageDialog(null, "Successfully deleted packages file...");
		}
		catch(Exception e) {  
			e.printStackTrace(); 
			System.out.println("Failure: packages.dat file not deleted...");
		}  
	}
	
	// Search Functions
	
	public void searchAccommodations(String keyword) {
		DefaultListModel<Accommodation> accomOGListModel = accomListModel;
		if(keyword != null) {
			accomListModel.clear();
			for (Accommodation a:arrayAccom) {
				if (a.toString().toLowerCase().contains(keyword.toLowerCase())) {
					accomListModel.addElement(a);
				}
		    }
		}
		else {
			accomListModel = accomOGListModel;
		}
	}
	public void searchCustomers(String keyword) {
		DefaultListModel<Customer> custOGListModel = custListModel;
		if(keyword != null) {
			custListModel.clear();
			for (Customer c:arrayCust) {
				if (c.toString().toLowerCase().contains(keyword.toLowerCase())) {
					custListModel.addElement(c);
				}
		    }
		}
		else {
			custListModel = custOGListModel;
		}
		
	}
	public void searchTravelPackages(String keyword) {
		DefaultListModel<TravelPackage> packOGListModel = packListModel;
		if(keyword != null) {
			packListModel.clear();
			for (TravelPackage p:arrayPack) {
				if (p.toString().toLowerCase().contains(keyword.toLowerCase())) {
					packListModel.addElement(p);
				}
		    }
		}
		else {
			packListModel = packOGListModel;
		}
		
	}
}

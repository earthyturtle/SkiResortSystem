package mtbuller;

import java.util.concurrent.atomic.AtomicInteger;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TravelPackage implements Serializable {
	private static final long serialVersionUID = 5073509801703518837L;
	static AtomicInteger packCount = new AtomicInteger(0);
	private int packID;
	private Customer customer;
	private Accommodation accommodation;
	private LocalDate arrival;
	private LocalDate departure;
	private ENUMliftPassValues liftPass;
	private int lessons;

	// Constructors
	
	public TravelPackage(Customer cust, Accommodation accom, LocalDate arrival, LocalDate departure, int lessons, ENUMliftPassValues liftPass) {
		packID = packCount.incrementAndGet();
		customer = cust;
		accommodation = accom;
		this.arrival = arrival;
		this.departure = departure;
		this.lessons = lessons;
		this.liftPass = liftPass;
	}

	// Getters
	
	public int getPackID() {
		return packID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Accommodation getAccommodation() {
		return accommodation;
	}
	public LocalDate getArrival() {
		return arrival;
	}
	public LocalDate getDeparture() {
		return departure;
	}
	public int getLessons() {
		return lessons;
	}
	public ENUMliftPassValues getLiftPass() {
		return liftPass;
	}

	//Setters
	
	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}
	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}
	public void setLiftPass(ENUMliftPassValues liftPass) {
		this.liftPass = liftPass;
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
	}

	// Strings
	
	@Override
	public String toString() {
		ENUMexperience experience = customer.getExperience();
		long intervalDays = ChronoUnit.DAYS.between(arrival, departure);
		return "<html>" + packID + ": Travel Package for " + customer.getFname() + " " + customer.getLname()
				+ "<br />Staying at " + accommodation.getName() + " - From " + arrival + " till " + departure + " a total of " + elapsedTime()
				+ "<br />Cost of stay $" + (accommodation.getDailyCost() * intervalDays)
				+ "<br />Lift pass: " + liftPass.lowerCase() + ", Costing $" + liftPass.getLiftPassValues() 
				+ "<br />Number of " + customer.getExperience().lowerCase() + "($" + experience.getExperienceCost() + " per) Lessons: " + lessons + ", Costing $" + (lessons * experience.getExperienceCost())
				+ "<br /> Total Price: $" + ((accommodation.getDailyCost() * intervalDays) + liftPass.getLiftPassValues() + (lessons * experience.getExperienceCost()))
				+ "<br />........................................................................................................</html>";
	
	}

	// Non-Object Methods
	
	public static AtomicInteger getPackCount() {
		return packCount;
	}
	public static void setPackCount(AtomicInteger packCount) {
		TravelPackage.packCount = packCount;
	}
	
	// Object Methods
	
	public String elapsedTime() {
	    Period intervalPeriod = Period.between(arrival, departure);
	    String t1 = "";
	    String t2 = "";
	    String t3 = intervalPeriod.getDays() + " Days";
	    if (intervalPeriod.getYears() > 0)
	    {
	    	t1 = intervalPeriod.getYears() + " Years, ";
	    }
	    if (intervalPeriod.getMonths() > 0)
	    {
	    	t2 = intervalPeriod.getMonths() + " Months, ";
	    }
	    return t1 + t2 + t3;
	}
}

package mtbuller;

import java.util.concurrent.atomic.AtomicInteger;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import mtbuller.Customer.experience;

public class TravelPackage implements Serializable {
	private static final long serialVersionUID = 3;
	static AtomicInteger packCount = new AtomicInteger(0);
	private int packID;
	private int custID;
	private String custName;
	private experience experience;
	private int accomID;
	private String accomName;
	private double accomBaseCost;
	private LocalDate arrival;
	private LocalDate departure;
	private double accomTotalCost;
	private liftPassValues liftPass;
	private double liftCost = 0;
	private int lessons;
	private double lessonCost = 0;
	private double totalCost = 0;
	
	public TravelPackage() {
		packID = packCount.incrementAndGet();
	}

	public TravelPackage(int custID, experience experience, int accomID, String custName, String accomName, double baseCost, LocalDate arrival, LocalDate departure) {
		packID = packCount.incrementAndGet();
		this.custID = custID;
		this.custName = custName;
		this.experience = experience;
		this.accomID = accomID;
		this.accomName = accomName;
		accomBaseCost = baseCost;
		this.arrival = arrival;
		this.departure = departure;
		setAccomTotalCost();
		liftPass = liftPassValues.NOPASS;
		lessons = 0;
	}

	public TravelPackage(int custID, int accomID, experience experience, String custName, String accomName, LocalDate arrival, LocalDate departure, 
			liftPassValues liftPass, int lessons) {
		packID = packCount.incrementAndGet();
		this.custID = custID;
		this.custName = custName;
		this.experience = experience;
		this.accomID = accomID;
		this.accomName = accomName;
		this.arrival = arrival;
		this.departure = departure;
		setAccomTotalCost();
		this.liftPass = liftPass;
		setLiftCost();
		this.lessons = lessons;
		setLessonCost();
	}

	public static AtomicInteger getPackCount() {
		return packCount;
	}
	public static void setPackCount(AtomicInteger packCount) {
		TravelPackage.packCount = packCount;
	}

	public int getPackID() {
		return packID;
	}
	public int getCustID() {
		return custID;
	}
	public int getAccomID() {
		return accomID;
	}
	public LocalDate getArrival() {
		return arrival;
	}
	public LocalDate getDeparture() {
		return departure;
	}
	public liftPassValues getLiftPass() {
		return liftPass;
	}
	public double getLiftCost() {
		return liftCost;
	}
	public int getLessons() {
		return lessons;
	}
	public double getLessonCost() {
		return lessonCost;
	}
	public double getTotalCost() {
		return totalCost;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
	public void setExperience(experience experience) {
		this.experience = experience;
	}
	public void setAccomID(int accomID) {
		this.accomID = accomID;
	}
	public void setAccomBaseCost(double cost) {
		accomBaseCost = cost;
	}
	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}
	public void setDeparture(LocalDate departure) {
		this.departure = departure;
		setAccomTotalCost();
	}
	public void setAccomTotalCost() {
	    long intervalDays = ChronoUnit.DAYS.between(arrival, departure);
	    accomTotalCost = intervalDays * accomBaseCost;
		setTotalCost();
	}
	public void setLiftPass(liftPassValues liftPass) {
		this.liftPass = liftPass;
		setLiftCost();
	}
	public void setLiftCost() {
		double cost;
		switch(liftPass) {
		case DAYPASS:
			cost = 26;
			break;
		case FIVEDAY:
			cost = 117;
			break;
		case SEASON:
			cost = 200;
			break;
		default:
			cost = 0;
			break;
		}
		liftCost = cost;
		setTotalCost();
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
		setLessonCost();
	}
	
	public void setLessonCost() {
		double baseCost;
		switch(experience) {
		case INTERMEDIATE:
			baseCost = 20;
			break;
		case EXPERT:
			baseCost = 15;
			break;
		default:
			baseCost = 25;
			break;
		}
		lessonCost = baseCost * lessons;
		setTotalCost();
	}
	
	public void setTotalCost() {
		totalCost = accomTotalCost + liftCost + lessonCost;
	}

	@Override
	public String toString() {
		return packID + ": Travel Package for " + custID + ":" + custID + ", staying in " + accomID + ":" + accomID + " at $" + accomBaseCost + " per night. "
				+ "Arriving=" + arrival + ", Departing=" + departure + ", ( " + elapsedTime() + " ) Cost: $" + accomTotalCost + 
				"\n     Lift pass: " + liftPass + ", Cost: $" + liftCost + 
				"\n     Lessons: " + lessons + ", Cost: $" + lessonCost +
				"\n Total Price: $" + totalCost;
	
	}
	
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
	
	enum liftPassValues {
		NOPASS,
		DAYPASS,
		FIVEDAY,
		SEASON
	}
}

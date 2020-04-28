package mtbuller;

import java.util.concurrent.atomic.AtomicInteger;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TravelPackage implements Serializable {
    static AtomicInteger packCount = new AtomicInteger(0);
	private int packID;
	private int custID;
	private int accomID;
	private LocalDate arrival;
	private LocalDate departure;
	private liftPassValues liftPass; // can be used as a boolean for true and false and to check the number of days needed to create a season pass.
	private int lessons; // again can be used as a boolean true or false for lessons
	
	public TravelPackage() {
		packID = packCount.incrementAndGet();
	}

	public TravelPackage(int custID, int accomID, LocalDate arrival, LocalDate departure) {
		packID = packCount.incrementAndGet();
		this.custID = custID;
		this.accomID = accomID;
		this.arrival = arrival;
		this.departure = departure;
		liftPass = liftPassValues.NOPASS;
		lessons = 0;
	}

	public TravelPackage(int custID, int accomID, LocalDate arrival, LocalDate departure, liftPassValues liftPass, int lessons) {
		packID = packCount.incrementAndGet();
		this.custID = custID;
		this.accomID = accomID;
		this.arrival = arrival;
		this.departure = departure;
		this.liftPass = liftPass;
		this.lessons = lessons;
	}

	public AtomicInteger getPackCount() {
		return packCount;
	}
	public void setPackCount(AtomicInteger packCount) {
		this.packCount = packCount;
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
	public int getLessons() {
		return lessons;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
	public void setAccomID(int accomID) {
		this.accomID = accomID;
	}
	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}
	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}
	public void setLiftPass(liftPassValues liftPass) {
		this.liftPass = liftPass;
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
	}

	@Override
	public String toString() {
		return packID + ": CustID=" + custID + ", AccomID=" + accomID + ". Arriving=" + arrival + ", Departing=" + departure + "\n     Lift pass: " + liftPass + "\n     Lessons: " + lessons;
	}
	
	enum liftPassValues {
		NOPASS,
		DAYPASS,
		FIVEDAY,
		SEASON
	}
}

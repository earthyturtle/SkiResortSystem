package mtbuller;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


public class Accommodation implements Serializable {
	private static final long serialVersionUID = -6546186345992026980L;
	static AtomicInteger accomCount = new AtomicInteger(0);
	private int accomID;
	private String name;
	private String description;
	private ENUMaccomType type;
	private double dailyCost;
	private boolean onMount;
	private boolean snow;
	private boolean kidsFree;
	private boolean internet;
	private boolean available;
	
	// Constructors
	
	public Accommodation() {
		accomID = accomCount.incrementAndGet();
	}
	
	public Accommodation(String name, String description, ENUMaccomType type, double dailyCost, boolean onMount, boolean snow, boolean kidsFree, boolean internet) {
		accomID = accomCount.incrementAndGet();
		this.name = name;
		this.description = description;
		this.type = type;
		this.dailyCost = dailyCost;
		this.onMount = onMount;
		this.snow = snow;
		this.kidsFree = kidsFree;
		this.internet = internet;
		this.available = true;
	}

	// Getters
	
	public int getAccomID() {
		return accomID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public ENUMaccomType getType() {
		return type;
	}
	public double getDailyCost() {
		return dailyCost;
	}
	public boolean isOnMount() {
		return onMount;
	}
	public boolean isSnow() {
		return snow;
	}
	public boolean isKidsFree() {
		return kidsFree;
	}
	public boolean isInternet() {
		return internet;
	}
	public boolean isAvailable() {
		return available;
	}
	
	// Setters
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setType(ENUMaccomType type) {
		this.type = type;
	}
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}
	public void setOnMount(boolean onMount) {
		this.onMount = onMount;
	}
	public void setSnow(boolean snow) {
		this.snow = snow;
	}
	public void setKidsFree(boolean kidsFree) {
		this.kidsFree = kidsFree;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	// String
	
	@Override
	public String toString() {
		return "<html>" + accomID + ") " + name + " - " + type.lowerCase() + " - $" + dailyCost + " per Night" + "<br />"
				+ "\"" + description + "\"<br />" 
				+ "On Mountain? " + yesno(onMount) + " | Snow Guarantee? " + yesno(snow) + " | Kids Stay Free? " + yesno(kidsFree) + " | Internet? " + yesno(internet)
				+ Available(available) + "<br />........................................................................................................</html>";
	}
	
	// Non-Object Methods
	
	public static AtomicInteger getAccomCount() {
		return accomCount;
	}
	public static void setAccomCount(AtomicInteger accomCount) {
		Accommodation.accomCount = accomCount;
	}
	
	// Object Methods
	
	private String yesno (boolean bool) {
		if (bool == true)
		{
		return "Yes";
		}
		else
		{
		return "No";
		}
	}
	private String Available (boolean bool) {
		if (bool == true)
		{
		return "<br /> Available";
		}
		else
		{
		return null;
		}
	}
}
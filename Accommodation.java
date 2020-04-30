package mtbuller;

import java.util.concurrent.atomic.AtomicInteger;

public class Accommodation {
    static AtomicInteger accomCount = new AtomicInteger(0);
	private int accomID;
	private String name;
	private String description;
	private accomType type;
	private double dailyCost;
	private boolean onMount;
	private boolean snow;
	private boolean kidsFree;
	private boolean internet;
	private boolean available;
	
	public Accommodation() {
		accomID = accomCount.incrementAndGet();
	}
	
	public Accommodation(String name, String description, accomType type, double dailyCost, boolean onMount, boolean snow, boolean kidsFree, boolean internet, boolean available) {
		accomID = accomCount.incrementAndGet();
		this.name = name;
		this.description = description;
		this.type = type;
		this.dailyCost = dailyCost;
		this.onMount = onMount;
		this.snow = snow;
		this.kidsFree = kidsFree;
		this.internet = internet;
		this.available = available;
	}
	
	public static AtomicInteger getAccomCount() {
		return accomCount;
	}
	public static void setAccomCount(AtomicInteger accomCount) {
		Accommodation.accomCount = accomCount;
	}

	public int getAccomID() {
		return accomID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public accomType getType() {
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
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setType(accomType type) {
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

	@Override
	public String toString() {
		return accomID + ". " + name + " - " + type + " - $" + dailyCost + " per Night\n     " + description + "\n     On the Mountain? " + yesno(onMount) + " | Snow Guaranteed? " + yesno(snow) + " | Kids Stay Free? " + yesno(kidsFree) + " | Internet? " + yesno(internet) + " | Availablle Now? " + yesno(available);
	}
	
	public String  yesno(boolean bool) {
		if (bool == true)
		{
		return "Yes";
		}
		else
		{
		return "No";
		}
	}
	
	enum accomType {
		HOTEL,
		LODGE,
		APARTMENT
	}
}
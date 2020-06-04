package SkiResort;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Serializable {
	private static final long serialVersionUID = 867271506549177216L;
	static AtomicInteger custCount = new AtomicInteger(0);
	private int custID;
	private String fname;
	private String lname;
	private byte age;
	private ENUMexperience experience;
	private String phone;
	private String email;
	
	// Constructors
	
	public Customer() {
		custID = custCount.incrementAndGet();
	}
	
	public Customer(String fname, String lname, byte age, ENUMexperience experience, String phone, String email) {
		custID = custCount.incrementAndGet();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.experience = experience;
		this.phone = phone;
		this.email = email;
	}
	
	// Getters
	
	public int getCustID() {
		return custID;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public byte getAge() {
		return age;
	}
	public ENUMexperience getExperience() {
		return experience;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	// Setters
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public void setExperience(ENUMexperience experience) {
		this.experience = experience;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// Strings
	
	@Override
	public String toString() {
		return "<html>" + custID + ") " + fname + ", " + lname + " - " + age + " years old<br />" 
				+ "Skiing Experience: " + experience.lowerCase()
				+ "<br />Ph: " + phone + " | Em: " + email
				+ "<br />........................................................................................................</html>";
	}

	// Non-Object functions
	
	public static AtomicInteger getCustCount() {
		return custCount;
	}
	public static void setCustCount(AtomicInteger custCount) {
		Customer.custCount = custCount;
	}
}


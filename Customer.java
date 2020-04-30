package mtbuller;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    static AtomicInteger custCount = new AtomicInteger(0);
	private int custID;
	private String fname;
	private String lname;
	private byte age;
	private experience experience;
	private String phone;
	private String email;
	
	public Customer() {
		custID = custCount.incrementAndGet();
	}
	
	public Customer(String fname, String lname, byte age, experience experience, String phone, String email) {
		custID = custCount.incrementAndGet();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.experience = experience;
		this.phone = phone;
		this.email = email;
	}

	public static AtomicInteger getCustCount() {
		return custCount;
	}
	public static void setCustCount(AtomicInteger custCount) {
		Customer.custCount = custCount;
	}
	
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
	public experience getExperience() {
		return experience;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public void setExperience(experience experience) {
		this.experience = experience;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return custID + ". " + fname + ", " + lname + "\n     " + age + " years old | " + experience + " ski experience\n     Ph: " + phone + " | Em: " + email;
	}
	public String toAbbString() {
		return custID + ". " + fname + ", " + lname;
	}

	enum experience {
		BEGINNER,
		INTERMEDIATE,
		EXPERT
	}
}


package Application;

public class Friend {
	
	private String firstName;
	private String lastName;
	private int age;
	private String hobby;
	private long phoneNumber;
	
	public Friend () {
		this.firstName = "John";
		this.lastName = "Doe";
		this.age = 25;
		this.hobby = "Reading";
		this.phoneNumber = 999999999;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long l) {
		this.phoneNumber = l;
	}
	
	
}

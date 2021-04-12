import java.util.*;
public class Teacher {
	private String firstName;
	private String lastName;
	private String subject;
	
	//constructor
	public Teacher () { 
		firstName = "John";
		lastName = "Doe";
		subject = "English";
	}

	//the followings are getters and setters
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	//prints teacher information
	public void printTeacherInfo () {
		System.out.println("Name: " + this.firstName + " " + this.lastName + " Subject: " + this.subject);
	}
}

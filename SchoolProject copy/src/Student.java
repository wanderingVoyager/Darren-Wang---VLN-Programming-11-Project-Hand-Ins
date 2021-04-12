import java.util.*;
public class Student {
	private String firstName;
	private String lastName;
	private int grade;
	private static int nextStudentNumber = 1; //stores the next number 
	private int studentNumber; 
	
	//constructor
	public Student () {
		firstName = "John";
		lastName = "Doe";
		grade = 9;
		studentNumber = nextStudentNumber;
		nextStudentNumber ++; //increments and becomes the next number
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}	
	
	//prints student information
	public void printStudentInfo () {
		System.out.println("Name: " + this.firstName + " " + this.lastName + " Grade: " + this.grade);
	}
}

package Application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
	
	public String firstName;
	public String lastName;
	private int age;
	private String hobby;
	private long phoneNumber;
	public String groupName;
	
	public Friend () {
		this.firstName = "John";
		this.lastName = "Doe";
		this.age = 25;
		this.hobby = "Reading";
		this.phoneNumber = 999999999;
		this.groupName = "Friends";
	}
	
	public Friend (String firstName, String lastName, int age, String hobby, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.hobby = hobby;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
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
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void writeToAllFriends () throws IOException {
		FileWriter fw = new FileWriter("All Friends.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(firstName + "\r");
		bw.write(lastName + "\r");
		bw.write(Integer.toString(age) + "\r");
		bw.write(hobby + "\r");
		bw.write(Long.toString(phoneNumber) + "\r");
		bw.write("END OF THIS FRIEND'S BIO" + "\r");
		bw.close();
	}
	
	public void writeToFriendGroup () throws IOException {
		FileWriter fw = new FileWriter(groupName + ".txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(firstName + "\r");
		bw.write(lastName + "\r");
		bw.write(Integer.toString(age) + "\r");
		bw.write(hobby + "\r");
		bw.write(Long.toString(phoneNumber) + "\r");
		bw.write("END OF THIS FRIEND'S BIO" + "\r");
		bw.close();
	}
	
	public void writeToFriendGroupNames (String groupName) throws IOException {
		FileWriter fw = new FileWriter("FriendGroupName.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(groupName + "\r");
		bw.close();
	}
}

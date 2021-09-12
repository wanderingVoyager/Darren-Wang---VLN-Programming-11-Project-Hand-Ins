package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Task {
	private String name;
	private Date dueDate;
	private Date dateCreated;
	
	public Task () {
		this.name = null;
		this.dueDate = null;
		this.dateCreated = null;
	}
	
	//The followings are getter and setter methods for the fields of this class

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	//overrides so that the name is returned, instead of the memory location
	@Override
	public String toString() {
		return name;
	}
	
	//Requires: a file to write to, valid data stored in that file
	//Modifies: the given file
	//Effects: writes the attributes of this task to the given file 
	public void writeToFile (String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(name + "\r");
		bw.write(dateCreated.getTime() + "\r");
		bw.write(dueDate.getTime()+ "\r");
		bw.write("END OF THIS TASK INFO" + "\r");
		bw.close();
	}
	
	//Requires: the current date
	//Modifies: N/A
	//Effects: returns true if the task is overdue
	public boolean isOverdue (Date currentDate) {
		if (currentDate.before(dueDate))
			return false;
		return true;
	}
	
	//Requires: valid attributes of the task
	//Modifies: DeletedTasks.txt
	//Effects: writes to DeletedTasks.txt
	public void writeToDeletedTasks () throws IOException {
		FileWriter fw = new FileWriter("DeletedTasks.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(dateCreated.toString() + "\r"); //note that date created must be unique because it is impossible in this program to create multiple tasks at the same time, so this best represents this task
		bw.close();
	}
}

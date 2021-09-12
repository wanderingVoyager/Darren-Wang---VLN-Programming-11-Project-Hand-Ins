package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class CreateAndLoadTasks {
	private static String name;
	private static Date dateCreated;
	private static Date dueDate;
	private static FileReader fr;
	private static BufferedReader br;
	public static HashSet <String> uniqueNames = new HashSet<>();
	public static ArrayList <Task> tasks = new ArrayList<>();
	public static ArrayList <String> removed = new ArrayList<>();
	
	//Requires: a file to write to, valid data stored in given text file
	//Modifies: uniqueNames, tasks, and attributes of each task loaded from the given file
	//Effects: data is loaded from the given file, converted into a Task object, and then returned as an ArrayList
	public static ArrayList <Task> loadTasks (String fileName) throws IOException {
		fr = new FileReader (fileName);
		br = new BufferedReader(fr);
		
		while ((name = br.readLine()) != null) {
			dateCreated = new Date(Long.parseLong(br.readLine()));
			dueDate = new Date(Long.parseLong(br.readLine()));
			br.readLine();
			
			Task addTask = new Task ();
			addTask.setName(name);
			addTask.setDateCreated(dateCreated);
			addTask.setDueDate(dueDate);
			
			if (!uniqueNames.contains(name)) { //to prevent any duplicates from being loaded
				tasks.add(addTask);
			}
			
			uniqueNames.add(name);
		}
		
		fr.close();
		br.close();
		
		return tasks;
	}
	
	//Requires: valid data stored in DeletedTasks.txt
	//Modifies: removed
	//Effects: loads deleted tasks from DeletedTasks and return directly in an ArrayList of type String
	public static ArrayList <String> deletedTasks () throws IOException {
		fr = new FileReader ("DeletedTasks.txt");
		br = new BufferedReader(fr);
		
		String line = "";
		
		while ((line = br.readLine()) != null) {
			removed.add(line);
		}
		
		return removed;
	}
}

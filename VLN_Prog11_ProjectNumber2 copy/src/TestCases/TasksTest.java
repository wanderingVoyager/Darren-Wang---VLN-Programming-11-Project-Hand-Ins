package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import application.CreateAndLoadTasks;
import application.Task;

public class TasksTest {
	Task task;
	Task task2;
	CreateAndLoadTasks createAndLoad;
	
	@Before
	public void setUp () {
		task = new Task();
		task.setName("task1");
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 5); 
		cal.set(Calendar.DAY_OF_MONTH, 28);
		cal.set(Calendar.HOUR_OF_DAY, 5);
		cal.set(Calendar.MINUTE, 0);
		Date dueDate = cal.getTime();
		task.setDueDate(dueDate); //5:00 June 28, 2020
		task.setDateCreated(new Date());
		
		task2 = new Task();
		task2.setName("task2");
		Calendar cal2 = new GregorianCalendar();
		cal2.set(Calendar.YEAR, 2023);
		cal2.set(Calendar.MONTH, 7); 
		cal2.set(Calendar.DAY_OF_MONTH, 12);
		cal2.set(Calendar.HOUR_OF_DAY, 7);
		cal2.set(Calendar.MINUTE, 0);
		Date dueDate2 = cal2.getTime();
		task2.setDueDate(dueDate2); 
		task2.setDateCreated(new Date());
		
		createAndLoad= new CreateAndLoadTasks();
	}
	
	@Test
	public void testWriteToFile() throws IOException {
		//testing if data persistence is functioning (if data is being written to the AllTasks.txt file)
		task.writeToFile("AllTasks.txt");
		task2.writeToFile("AllTasks.txt");
		
		FileReader fr = new FileReader ("AllTasks.txt");
		BufferedReader br = new BufferedReader (fr);
		
		assertEquals(br.readLine(), task.getName());
		assertEquals(br.readLine(), String.valueOf(task.getDateCreated().getTime()));
		assertEquals(br.readLine(), String.valueOf(task.getDueDate().getTime()));
		br.readLine();
		
		assertEquals(br.readLine(), task2.getName());
		assertEquals(br.readLine(), String.valueOf(task2.getDateCreated().getTime()));
		assertEquals(br.readLine(), String.valueOf(task2.getDueDate().getTime()));
		br.readLine();
		
		fr.close();
		br.close();
		
		FileWriter fw = new FileWriter ("AllTasks.txt");
		fw.close(); //this clears the text file since it is for testing, not for real application
	}
	
	@Test
	public void testIsOverdue () {
		//testing if the isOverdue() method working
		assertTrue(task.isOverdue(new Date()));
	}
	
	@Test
	public void testLoadTasks () throws IOException {
		//testing if tasks are being loaded properly from the text file
		task.writeToFile("AllTasks.txt");
		task2.writeToFile("AllTasks.txt");
		
		ArrayList <Task> test = createAndLoad.loadTasks("AllTasks.txt");
		
		Task temp1 = test.get(0);
		Task temp2 = test.get(1);
		
		assertEquals(temp1.toString(), task.toString());
		assertEquals(temp2.toString(), task2.toString());
		
		FileWriter fw = new FileWriter ("AllTasks.txt");
		fw.close(); //this clears the text file since it is for testing, not for real application
	}
}

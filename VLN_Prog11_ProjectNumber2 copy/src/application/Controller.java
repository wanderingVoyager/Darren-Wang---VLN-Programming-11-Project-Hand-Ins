package application;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class Controller { 
	@FXML TextField textTaskName;
	@FXML TextField textDay;
	@FXML TextField textMonth;
	@FXML TextField textYear;
	@FXML TextField textHour;
	@FXML TextField textMinute;
	@FXML Button saveTaskButton;
	@FXML public ListView<Task> tasksList;
	@FXML Button buttonLoadAll;
	@FXML Button buttonLoadToDo;
	@FXML Button buttonLoadOverdue;
	@FXML Label lblTaskName;
	@FXML Label lblDateCreated;
	@FXML Label lblDueDate;
	@FXML Label lblOverdue;
	@FXML Button buttonMarkAsDone;
	
	
	//Requires: valid user inputs for each of the text fields
	//Modifies: AllTasks.txt, tasksList
	//Effects: writing data into AllTasks.txt for data persistence and adds new task onto taskList
	@FXML public void saveTask () throws IOException {
		Task newTask = new Task();
		newTask.setName(textTaskName.getText());
		
		//Sets the due date for the task
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, Integer.parseInt(textYear.getText()));
		cal.set(Calendar.MONTH, Integer.parseInt(textMonth.getText()) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(textDay.getText()));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(textHour.getText()));
		cal.set(Calendar.MINUTE, Integer.parseInt(textMinute.getText()));
		Date dueDate = cal.getTime();
		
		newTask.setDueDate(dueDate);
		newTask.setDateCreated(new Date());
		
		tasksList.getItems().add(newTask);
		
		ObservableList <Task> list = tasksList.getItems();
		
		for (Task t : list) {
			if (!CreateAndLoadTasks.uniqueNames.contains(t.toString())) {
				t.writeToFile("AllTasks.txt");
			}
		}
		
		textTaskName.clear();
		textDay.clear();
		textMonth.clear();
		textYear.clear();
		textHour.clear();
		textMinute.clear();
		tasksList.getItems().clear();
	}
	
	//Requires: valid data stored in AllTasks.txt, DeletedTasks.txt
	//Modifies: tasksList
	//Effects: loads data of all tasks from AllTasks.txt into tasksList
	@FXML public void loadAllTasks () throws IOException {
		tasksList.getItems().clear();
		ArrayList <Task> tasks = CreateAndLoadTasks.loadTasks("AllTasks.txt");
		
		for (Task t : tasks) {
			if (!CreateAndLoadTasks.deletedTasks().contains(t.getDateCreated().toString()))
				tasksList.getItems().add(t);
		}
	}
	
	//Requires: valid data stored in AllTasks.txt, DeletedTasks.txt
	//Modifies: tasksList
	//Effects: loads data of non-overdue tasks from AllTasks.txt into tasksList
	@FXML public void loadToDoTasks () throws IOException {
		tasksList.getItems().clear();
		ArrayList <Task> tasks = CreateAndLoadTasks.loadTasks("AllTasks.txt");
		
		for (Task t : tasks) {
			if (!t.isOverdue(new Date()) && !CreateAndLoadTasks.deletedTasks().contains(t.getDateCreated().toString())) {
				tasksList.getItems().add(t);
			}
		}
	}
	
	//Requires: valid data stored in AllTasks.txt
	//Modifies: tasksList
	//Effects: loads data of overdue tasks from AllTasks.txt into tasksList
	@FXML public void loadOverdueTasks () throws IOException{
		tasksList.getItems().clear();
		ArrayList <Task> tasks = CreateAndLoadTasks.loadTasks("AllTasks.txt");
		
		for (Task t : tasks) {
			if (t.isOverdue(new Date()) && !CreateAndLoadTasks.deletedTasks().contains(t.getDateCreated().toString())) {
				tasksList.getItems().add(t);
			}
		}
	}
	
	//Requires: labels to display task attributes and selected item of the taskList
	//Modifies: labels for display
	//Effects: displays attributes of the selected task
	@FXML public void displayTaskInfo () {
		Task t = tasksList.getSelectionModel().getSelectedItem();
		lblTaskName.setText(t.getName());
		lblDateCreated.setText(t.getDateCreated().toString());
		lblDueDate.setText(t.getDueDate().toString());
		
		if (t.isOverdue(new Date()))
			lblOverdue.setText("True");
		else 
			lblOverdue.setText("False");
		
		buttonMarkAsDone.setDisable(false);
	}
	
	//Requires: valid data stored in AllTasks.txt, selected item of tasksList
	//Modifies: tasksList, DeletedTasks.txt
	//Effects: removes the selected item from the tasksList and writes to DeletedTasks.txt
	@FXML public void deleteTask () throws IOException {
		Task removeTask = tasksList.getSelectionModel().getSelectedItem();
		tasksList.getItems().remove(removeTask);
		
		removeTask.writeToDeletedTasks();
		
		buttonMarkAsDone.setDisable(true);
	}
}

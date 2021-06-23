package Application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class Controller {

	@FXML TextField textFirstName;
	@FXML TextField textLastName;
	@FXML TextField textAge;
	@FXML TextField textHobby;
	@FXML TextField textPhoneNumber;
	@FXML Button buttonAddFriend; 
	@FXML public ListView<Friend> friendsList = new ListView <> ();
	static int friendsCount = 0;
	@FXML Label lblLastName;
	@FXML Label lblAge;
	@FXML Label lblHobby;
	@FXML Label lblPhoneNumber;
	@FXML Label lblFirstName;
	@FXML Label lblFriendsNum;
	@FXML Button buttonLoadAllFriends;
	@FXML Button buttonEnteraddOrCreateFriendGroup;
	@FXML TextField textAddOrCreateFriendGroup;
	@FXML Button buttonLoadFriendGroup;
	
	String firstNameSaved;
	String lastNameSaved;
	int ageSaved;
	String hobbySaved;
	Long phoneNumberSaved;
	@FXML ListView <String> groupList = new ListView<>();
	
	@FXML public void addFriend() throws IOException { 
		Friend newFriend = new Friend();
		newFriend.setFirstName(textFirstName.getText());
		newFriend.setLastName(textLastName.getText());
		newFriend.setAge(Integer.parseInt(textAge.getText()));
		newFriend.setHobby(textHobby.getText());
		newFriend.setPhoneNumber(Long.parseLong(textPhoneNumber.getText()));
		friendsList.getItems().add(newFriend);
		
		firstNameSaved = textFirstName.getText();
		lastNameSaved = textLastName.getText();
		ageSaved = Integer.parseInt(textAge.getText());
		hobbySaved = textHobby.getText();
		phoneNumberSaved = Long.parseLong(textPhoneNumber.getText());
		
		friendsCount++;
		
		ObservableList <Friend> list = friendsList.getItems();
		
		for (Friend f : list) {
			if (!CreateAndLoadFriend.uniqueNames.contains(f.firstName + " " + f.lastName)) {
				f.writeToAllFriends(); 
			}
		}
		
		friendsList.getItems().clear();
		groupList.getItems().clear();
		lblFriendsNum.setText("Number of Friends: " + Integer.toString(friendsCount));
		textFirstName.clear();
		textLastName.clear();
		textAge.clear();
		textHobby.clear();
		textPhoneNumber.clear();
		buttonLoadAllFriends.setDisable(false);
		buttonLoadFriendGroup.setDisable(false);
	}

	@FXML public void displayFriendInfo() {
		Friend temp;
		temp = friendsList.getSelectionModel().getSelectedItem();
		lblFirstName.setText(temp.getFirstName());
		lblLastName.setText(temp.getLastName());
		lblAge.setText(Integer.toString(temp.getAge()));
		lblHobby.setText(temp.getHobby());
		lblPhoneNumber.setText(Long.toString(temp.getPhoneNumber()));
	}

	@FXML public void loadAllFriends() throws IOException { 
		friendsList.getItems().clear();
		ArrayList <Friend> friends = CreateAndLoadFriend.createAndLoadAllFriends();
		
		for (Friend f : friends) {
			friendsList.getItems().add(f);
		}
	}

	@FXML public void addOrCreateFriendGroup() throws IOException {
		Friend newFriend = new Friend(firstNameSaved, lastNameSaved, ageSaved, hobbySaved, phoneNumberSaved);
		if (!CreateAndLoadFriend.uniqueNames.contains(newFriend.firstName + " " + newFriend.lastName)) {
			newFriend.setGroupName(textAddOrCreateFriendGroup.getText());
			newFriend.writeToFriendGroup(); 
		}
		
		groupList.getItems().add(textAddOrCreateFriendGroup.getText());
		newFriend.writeToFriendGroupNames(textAddOrCreateFriendGroup.getText());
		
		textAddOrCreateFriendGroup.clear();
	}

	@FXML public void displayGroup() throws IOException {
		friendsList.getItems().clear();
		String temp; 
		temp = groupList.getSelectionModel().getSelectedItem();
		ArrayList <Friend> friendsInFriendGroup = CreateAndLoadFriend.createAndLoadFriendGroup(temp);
		
		for (Friend f : friendsInFriendGroup) {
			friendsList.getItems().add(f);
		}
	}

	@FXML public void loadFriendGroupNames() throws IOException {
		groupList.getItems().clear();
		ArrayList <String> groupNames = CreateAndLoadFriend.createAndLoadFriendGroupNames();
		
		for (String s : groupNames) {
			groupList.getItems().add(s);
		}
		
		buttonLoadFriendGroup.setDisable(true);
	}
}

package Application;

import java.util.List;

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
	@FXML Button buttonAddFriend; //needs disabling
	@FXML public ListView<Friend> friendsList = new ListView <> ();
	static int friendsCount = 0;
	@FXML Label lblLastName;
	@FXML Label lblAge;
	@FXML Label lblHobby;
	@FXML Label lblPhoneNumber;
	@FXML Label lblFirstName;
	@FXML Button buttonRemoveFriend; //needs disabling
	@FXML Label lblFriendsNum;
	
	@FXML public void addFriend() {
		buttonRemoveFriend.setDisable(true);
		Friend newFriend = new Friend();
		newFriend.setFirstName(textFirstName.getText());
		newFriend.setLastName(textLastName.getText());
		newFriend.setAge(Integer.parseInt(textAge.getText()));
		newFriend.setHobby(textHobby.getText());
		newFriend.setPhoneNumber(Long.parseLong(textPhoneNumber.getText()));
		friendsList.getItems().add(newFriend);
		friendsCount++;
		lblFriendsNum.setText("Number of Friends: " + Integer.toString(friendsCount));
		textFirstName.clear();
		textLastName.clear();
		textAge.clear();
		textHobby.clear();
		textPhoneNumber.clear();
	}

	@FXML public void displayFriendInfo() {
		Friend temp;
		temp = friendsList.getSelectionModel().getSelectedItem();
		lblFirstName.setText(temp.getFirstName());
		lblLastName.setText(temp.getLastName());
		lblAge.setText(Integer.toString(temp.getAge()));
		lblHobby.setText(temp.getHobby());
		lblPhoneNumber.setText(Long.toString(temp.getPhoneNumber()));
		buttonRemoveFriend.setDisable(false);
	}

	@FXML public void removeFriend() {
		Friend temp;
		temp = friendsList.getSelectionModel().getSelectedItem();
		friendsList.getItems().remove(temp);
		friendsCount --;
		
		if (friendsCount < 0) {
			friendsCount = 0; 
		}
		
		lblFriendsNum.setText("Number of Friends: " + Integer.toString(friendsCount));
		lblFirstName.setText("");
		lblLastName.setText("");
		lblAge.setText("");
		lblHobby.setText("");
		lblPhoneNumber.setText("");
		
		buttonRemoveFriend.setDisable(true);
	}
	
}

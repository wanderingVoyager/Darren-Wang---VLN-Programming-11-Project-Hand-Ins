package Application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

	@FXML public TextField textAmtEntered;
	@FXML public Label lblTotalAmt;
	@FXML public Button buttonEnter;
	public static double total = 0;
	@FXML Button buttonRollDice1;
	@FXML Label lblDice1;
	@FXML Button buttonNo;
	@FXML Button buttonYes;
	@FXML Label lblDice2;
	public Dice dice1;
	public Dice dice2;
	@FXML Label lblFinalResult;
	@FXML Button buttonReplay; 
	

	@FXML public void enterMoneyToPlay() {
		buttonNo.setDisable(true);
		buttonYes.setDisable(true);
		double amtNew = Double.parseDouble(textAmtEntered.getText());
		total += amtNew;
		lblTotalAmt.setText("$" + Double.toString(total));
		textAmtEntered.clear();
		buttonEnter.setDisable(true);
		buttonRollDice1.setDisable(false);
	}

	@FXML public void rollDice1() {
		dice1 = new Dice();
		dice2 = new Dice();
		lblDice1.setText("Dice 1 Result: " + dice1.toString());
		buttonRollDice1.setDisable(true);
		buttonNo.setDisable(false);
		buttonYes.setDisable(false);
	}

	@FXML public void dice2Smaller() {
		buttonNo.setDisable(true);
		buttonYes.setDisable(true);
		lblDice2.setText("Dice 2 Result: " + dice2.toString());

		if(Integer.parseInt(dice2.toString()) < Integer.parseInt(dice1.toString())) {
			lblFinalResult.setText("Final Result: You win!");
			total += 1;
			lblTotalAmt.setText("$" + Double.toString(total));
		}
		
		else {
			lblFinalResult.setText("Final Result: You lose!");
			total -= 100;
			lblTotalAmt.setText("$" + Double.toString(total));
		}
		
		buttonReplay.setDisable(false);
	}

	@FXML public void dice2Larger() {
		buttonYes.setDisable(true);
		buttonNo.setDisable(true);
		lblDice2.setText("Dice 2 Result: " + dice2.toString());

		if(Integer.parseInt(dice2.toString()) > Integer.parseInt(dice1.toString())) {
			lblFinalResult.setText("Final Result: You win!");
			total += 1;
			lblTotalAmt.setText("$" + Double.toString(total));
		}
		
		else {
			lblFinalResult.setText("Final Result: You lose!");
			total -= 100;
			lblTotalAmt.setText("$" + Double.toString(total));
		}
		
		buttonReplay.setDisable(false);
	}

	@FXML public void replay() {
		buttonRollDice1.setDisable(false);
		buttonEnter.setDisable(false);
		buttonReplay.setDisable(true);
		lblFinalResult.setText("Final Result:");
		lblDice1.setText("Dice 1 Result:");
		lblDice2.setText("Dice 2 Result:");
	}
	
}

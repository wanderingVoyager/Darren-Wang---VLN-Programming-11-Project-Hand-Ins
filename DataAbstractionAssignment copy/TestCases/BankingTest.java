import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingTest {
	Deposit testDeposit;
	Customer testCustomer;
	Withdraw testWithdraw;
	double amt;
	Date date;
	String accountSaving;
	String accountChecking;
	
	@BeforeEach
	public void setup () { 
		//setting up the object and some variables
		amt = 1000;
		date = new Date();
		accountSaving = Customer.SAVING;
		accountChecking = Customer.CHECKING;
		testDeposit = new Deposit(amt, date, accountSaving);
		testWithdraw = new Withdraw(amt, date, accountSaving);
		testCustomer = new Customer("Darren Wang", 123, 1500, 1800);
	}
	
	@Test
	public void testDepositToString () {
		//testing if the toString() method prints the right phrases
		assertEquals(testDeposit.toString(), "Deposit of: $" + amt + " Date: " + date + " into account: " + accountSaving);
	}
	
	@Test 
	public void testWithdrawToString() {
		//testing if the toString() method prints the right phrases
		assertEquals(testWithdraw.toString(), "Withdraw of: $" + amt + " Date: " + date + " from account: " + accountSaving);
	}
	
	@Test 
	public void testCustomerDeposit() {
		//testing if deposit() works and if the right amounts are added to the corresponding accounts 
		testCustomer.deposit(150, date, accountChecking); 
		assertEquals(testCustomer.getCheckBalance(), 1650);
		testCustomer.deposit(250, date, accountSaving);
		assertEquals(testCustomer.getSavingBalance(), 2050);
	}
	
	@Test 
	public void testCustomerWithdraw() {
		//testing if withdraw() works and if the right amounts are deducted from the corresponding accounts 
		testCustomer.withdraw(200, date, accountChecking);
		assertEquals(testCustomer.getCheckBalance(), 1300);
		testCustomer.withdraw(200, date, accountSaving);
		assertEquals(testCustomer.getSavingBalance(), 1600);
		//testing overdrafts and see if it is executed
		assertEquals(testCustomer.withdraw(2000, date, accountSaving), -400);
		assertEquals(testCustomer.getSavingBalance(), 0);
	}
	
}

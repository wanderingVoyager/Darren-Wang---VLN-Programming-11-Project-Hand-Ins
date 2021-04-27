import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;

	private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private double OVERDRAFT = -100;

    Customer(){
        //create default constructor
    	name = "John Doe";
    	checkBalance = 0.0;
    	savingBalance = 0.0;
    	accountNumber = 1;
    	savingRate = 0.0;
    	deposits = new ArrayList <>();
    	withdraws = new ArrayList <>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
    	this.name = name;
    	this.accountNumber = accountNumber;
    	this.checkBalance = checkDeposit;
    	this.savingBalance = savingDeposit;
    	deposits = new ArrayList <>();
    	withdraws = new ArrayList <>();
    }
    
    //requires: double, Date, and String
    //modifies: the corresponding account balance, such as checkBalance or savingBalance
    //effects: returns the new balance in the corresponding account modified
    public double deposit(double amt, Date date, String account){
        //your code here
    	Deposit d = new Deposit(amt, date, account);
    	deposits.add(d);
    	System.out.println(d);
    	
        if (account.equals(SAVING)) {
        	savingBalance += amt;
        	System.out.print("Amount in your saving account: $");
        	return savingBalance;
        }
        
        else if (account.equals(CHECKING)){
        	checkBalance += amt;
        	System.out.print("Amout in your checking account: $");
        	return checkBalance;
        }
        
        else {
        	return -1;
        }
    }
    
    //requires: double, Date, String
    //modifies: the corresponding account balance
    //effects: returns the modified corresponding account balance, and prints overdraft messages, if applicable, and returns overdraft amount
    public double withdraw(double amt, Date date, String account){
        Withdraw w = new Withdraw (amt, date, account);
        withdraws.add(w);
        
        if (account.equals(SAVING) && !checkOverdraft(amt, account)) {
        	System.out.println(w);
        	savingBalance -= amt;
        	System.out.print("Amount in your saving account: $");
        	return savingBalance;
        }
        
        else if (account.equals(CHECKING) && !checkOverdraft(amt, account)){
        	System.out.println(w);
        	checkBalance -= amt;
        	System.out.print("Amount in your checking account: $");
        	return savingBalance;
        }
        
        else if (checkOverdraft(amt, account)) {
        	System.out.println("Error, overdraft occured.");
        	if (account.equals(Customer.SAVING)) {
        		OVERDRAFT = savingBalance - amt;
        		savingBalance = 0;
        	}
        	
        	else if (account.contentEquals(Customer.CHECKING)) {
        		OVERDRAFT = checkBalance - amt;
        	}
        	
        	System.out.print("You borrowed $");
        	return OVERDRAFT;
        }
        
        else {
        	System.out.println("Error, no account found.");
        	return -1;
        }
    }
    
    private boolean checkOverdraft(double amt, String account){
        //your code here
    	if (account.equals(SAVING)) {
    		if (amt > savingBalance) {
    			return true;
    		}
    	}
    	
    	else if (account.equals(CHECKING)) {
    		if (amt > checkBalance) {
    			return true;
    		}
    	}
    		
        return false;
    }
    
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
    
    public double getCheckBalance() {
  		return checkBalance;
  	}
    
  	public double getSavingBalance() {
  		return savingBalance;
  	}
  	
  	public void setSavingBalance(double savingBalance) {
  		this.savingBalance = savingBalance;
  	}

}

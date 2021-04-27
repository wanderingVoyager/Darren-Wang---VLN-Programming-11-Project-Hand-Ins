import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    
    //requires: an amount (double), a date (Date), and an account (String)
    //effects: returns informative messages in regards to the info given from the constructor
    public String toString(){
        //your code here
    	if (account.equals(Customer.SAVING)) {
    		return "Deposit of: $" + amount + " Date: " + date + " into account: " + Customer.SAVING;
    	}
    	
    	else if (account.equals(Customer.CHECKING)){
    		return "Deposit of: $" + amount + " Date: " + date + " into account: " + Customer.CHECKING;
    	}
    	
    	else {
    		return "Error, no account found.";
    	}
    }
}

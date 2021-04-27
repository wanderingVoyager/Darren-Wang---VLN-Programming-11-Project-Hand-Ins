import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    
    //requires: an amount (double), a date (Date), and an account (String)
    //effects: returns informative messages in regards to the info given from the constructor
    public String toString(){
        //your code here
    	if (account.equals(Customer.SAVING)) {
    		return "Withdraw of: $" + amount + " Date: " + date + " from account: " + Customer.SAVING;
    	}
    	
    	else if (account.contentEquals(Customer.CHECKING)){
    		return "Withdraw of: $" + amount + " Date: " + date + " from account: " + Customer.CHECKING;
    	}
    	
    	else {
    		return "Error, no account found.";
    	}
    }
}

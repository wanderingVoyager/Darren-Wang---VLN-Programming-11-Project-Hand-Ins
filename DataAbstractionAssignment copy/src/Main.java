import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer ("Darren Wang", 123, 1800, 1500);
		Date date = new Date();
		System.out.println(c.deposit(1000, date, "Saving"));
		System.out.println(c.withdraw(2400, date, "Saving"));
		System.out.println(c.withdraw(300, date, "Saving"));
	}

}

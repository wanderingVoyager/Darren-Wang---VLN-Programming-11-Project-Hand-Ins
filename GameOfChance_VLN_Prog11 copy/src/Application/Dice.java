package Application;

public class Dice {
	int num;
	
	public Dice () {
		num = (int) ((Math.random()) * 6 + 1);
	}
	
	public String toString() {
		return Integer.toString(num);
	}
}

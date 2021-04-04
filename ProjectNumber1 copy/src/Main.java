
public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int count = 0;
        for (char ch : s.toCharArray()) { //converts the string into a character array and ch holds each element
        	switch(ch) {
        	case 'a':
        		count ++;
        		break;
        	case 'e':
        		count ++;
        		break;
        	case 'i':
        		count ++;
        		break;
        	case 'o':
        		count ++;
        		break;
        	case 'u':
        		count ++;
        		break;
        	default: 
        		continue;
        	}
        }
        
    	return count;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int count = 0;
        for (int i = 0; i + 2 < s.length(); i++) {
        	if (s.substring(i, i + 3).equals("bob")) {
        		count ++;
        	}
        }
        
        return count;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s) {
    	String currentString = "";
    	String longest = "";
    	char prevChar = ' ';
    	for (char ch : s.toCharArray()) { //converts s into an array and ch holds each element
    		
    		if (prevChar - ch <= 0) { //if this if statement is true, that means the this letter is in alphabetical order
    			currentString += ch;
    			
    			if (currentString.equals(s)) { 
    				longest = currentString;
    			}
    		}
    			
    		else if (currentString.length() > longest.length()) { //check if the currentString is longest
    			longest = currentString;
    			currentString = "" + ch; //this turns ch into string 
    		}
    		
    		else {
    			currentString = "" + ch; //this turns ch into string
    		}
    		
    		prevChar = ch;
    	}
    	
    	return longest;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s1 = "azcbobobegghakl";
        String s2 = "azcbobobegghakl";
        String s3 = "azcbobobegghakl";
        
        System.out.println("Number of vowels: " + problemOne(s1));
        System.out.println("Number of times bob occur: " + problemTwo(s2));
        System.out.println("Longest substring in alphabetical order: " + problemThree(s3));
        
    }
}

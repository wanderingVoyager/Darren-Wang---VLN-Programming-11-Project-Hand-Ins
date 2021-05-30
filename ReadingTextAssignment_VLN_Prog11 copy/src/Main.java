import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList <Integer> searchWord (ArrayList <String> lines, String word) {
		ArrayList <Integer> indices = new ArrayList <>();
		for (String s : lines) {
			if (s.contains(word)) {
				indices.add(lines.indexOf(s));
			}
		}
		
		return indices;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList <String> lines = new ArrayList <>();
		
		while ((line = br.readLine()) != null) { 
			lines.add(line);
		}
		
		br.close();
		
		for (int i : searchWord(lines, "computer")) {
			System.out.println("Index in ArrayList : " + i + "\t" + "Line number in input.txt : " + (i+1));
		}
	}

}

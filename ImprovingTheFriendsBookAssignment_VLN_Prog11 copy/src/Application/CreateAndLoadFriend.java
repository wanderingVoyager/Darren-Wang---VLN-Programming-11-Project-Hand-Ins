package Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CreateAndLoadFriend {
	
	private static String firstName;
	private static String lastName;
	private static int age;
	private static String hobby;
	private static long phoneNumber;
	private static FileReader fr;
	private static BufferedReader br;
	private static ArrayList <Friend> friends = new ArrayList<>();
	public static HashSet <String> uniqueNames = new HashSet<>();
	
	public static ArrayList <Friend> createAndLoadAllFriends () throws IOException {
		fr = new FileReader("All Friends.txt");
		br = new BufferedReader(fr);
		
		while ((firstName = br.readLine()) != null) {
			lastName = br.readLine();
			age = Integer.parseInt(br.readLine());
			hobby = br.readLine();
			phoneNumber = Long.parseLong(br.readLine());
			br.readLine();
			
			Friend addFriend = new Friend (firstName, lastName, age, hobby, phoneNumber);
			
			if (!uniqueNames.contains(firstName + " " + lastName)) {
				friends.add(addFriend);
			}
			uniqueNames.add(firstName + " " + lastName);
		}
		
		fr.close();
		br.close();
		
		return friends;
	}
	
	public static ArrayList <Friend> createAndLoadFriendGroup (String groupName) throws IOException {
		fr = new FileReader(groupName + ".txt");
		br = new BufferedReader(fr);
		HashSet <String> uniqueNamesInFriendGroup = new HashSet<>();
		ArrayList <Friend> friendsInFriendGroup = new ArrayList<>();
		
		while ((firstName = br.readLine()) != null) {
			lastName = br.readLine();
			age = Integer.parseInt(br.readLine());
			hobby = br.readLine();
			phoneNumber = Long.parseLong(br.readLine());
			br.readLine();
			
			Friend addFriend = new Friend (firstName, lastName, age, hobby, phoneNumber);
			
			if (!uniqueNamesInFriendGroup.contains(firstName + " " + lastName)) {
				friendsInFriendGroup.add(addFriend);
			}
			uniqueNamesInFriendGroup.add(firstName + " " + lastName);
		}
		
		fr.close();
		br.close();
		
		return friendsInFriendGroup;
	}
	
	public static ArrayList <String> createAndLoadFriendGroupNames () throws IOException {
		fr = new FileReader("FriendGroupName.txt");
		br = new BufferedReader(fr);
		HashSet <String> uniqueGroupNames = new HashSet<>();
		ArrayList <String> friendGroupNames = new ArrayList<>();
		String name = "";
		
		while ((name = br.readLine()) != null) {
			if (!uniqueGroupNames.contains(name)) {
				friendGroupNames.add(name);
			}
			uniqueGroupNames.add(name);
		}
		
		fr.close();
		br.close();
		
		return friendGroupNames;
	}
}

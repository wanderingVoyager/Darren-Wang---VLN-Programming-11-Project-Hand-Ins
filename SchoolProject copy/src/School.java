import java.util.ArrayList;

public class School {
    static ArrayList <Teacher> teachers = new ArrayList <> ();
    static ArrayList <Student> students = new ArrayList <> ();
    static ArrayList <String> courses = new ArrayList <> ();

    //constructor
    public School () {
    	teachers = new ArrayList <Teacher> ();
    	students = new ArrayList <Student> ();
    	courses = new ArrayList <String> ();
    }
    
    //the followings add and delete students & teachers 
    public static void addTeacher (Teacher name) {
    	teachers.add(name);
    }
    
    public static void addStudent (Student name) {
    	students.add(name);
    }
    
    public static void deleteTeacher (Teacher name) {
    	teachers.remove(name);
    }
    
    public static void deleteStudent (Student name) {
    	students.remove(name);
    }
    
    //shows all teachers of the ArrayList
    public static void showAllTeachers () {
    	for (Teacher t : teachers) { // t holds value of every element of the list per iteration
    		t.printTeacherInfo(); //t accesses the method that prints teacher information
    	}
    }
    
    //shows all teaches of the ArrayLIst
    public static void showAllStudents () {
    	for (Student s : students) { //s holds value of every element of the list per iteration
    		s.printStudentInfo(); //s accesses the method that prints the student information
    	}
    }

    //the followings are getters and setters
	public static ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public static void setTeachers(ArrayList<Teacher> teachers) {
		School.teachers = teachers;
	}

	public static ArrayList<Student> getStudents() {
		return students;
	}

	public static void setStudents(ArrayList<Student> students) {
		School.students = students;
	}

	public static ArrayList<String> getCourses() {
		return courses;
	}

	public static void setCourses(ArrayList<String> courses) {
		School.courses = courses;
	}
	
}

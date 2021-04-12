import java.util.*;
public class Main {
    public static void main(String[] args) {
    	School sc = new School();
    	
    	Student a = new Student();
    	Student b = new Student();
    	Student c = new Student();
    	Student d = new Student();
    	Student e = new Student();
    	Student f = new Student();
    	Student g = new Student();
    	Student h = new Student();
    	Student i = new Student();
    	Student j = new Student();
    	
    	Teacher k = new Teacher();
    	Teacher l = new Teacher();
    	Teacher m = new Teacher();
    	
    	a.setFirstName("Darren");
    	a.setLastName("Wang");
    	a.setGrade(9);
    	b.setFirstName("Donald");
    	b.setLastName("Trump");
    	b.setGrade(10);
    	c.setFirstName("George");
    	c.setLastName("Washington");
    	c.setGrade(12);
    	d.setFirstName("Leonardo");
    	d.setLastName("DiCaprio");
    	d.setGrade(11);
    	e.setFirstName("John");
    	e.setLastName("Green");
    	e.setGrade(8);
    	f.setFirstName("Dan");
    	f.setLastName("Lin");
    	f.setGrade(9);
    	g.setFirstName("Franklin");
    	g.setLastName("Roosevelt");
    	g.setGrade(10);
    	h.setFirstName("George");
    	h.setLastName("Bush");
    	h.setGrade(11);
    	i.setFirstName("Albert");
    	i.setLastName("Einstein");
    	i.setGrade(12);
    	j.setFirstName("Justin");
    	j.setLastName("Bieber");
    	j.setGrade(8);
    	
    	k.setFirstName("Winston");
    	k.setLastName("Churchill");
    	k.setSubject("History");
    	l.setFirstName("Pierre");
    	l.setLastName("Trudeau");
    	l.setSubject("French");
    	m.setFirstName("Taylor");
    	m.setLastName("Swift");
    	m.setSubject("Band");
    	
    	sc.addStudent(a);
    	sc.addStudent(b);
    	sc.addStudent(c);
    	sc.addStudent(d);
    	sc.addStudent(e);
    	sc.addStudent(f);
    	sc.addStudent(g);
    	sc.addStudent(h);
    	sc.addStudent(i);
    	sc.addStudent(j);
    	
    	sc.addTeacher(k);
    	sc.addTeacher(l);
    	sc.addTeacher(m);
    	
    	sc.showAllStudents();
    	System.out.println();
    	sc.showAllTeachers();
    	
    	sc.deleteStudent(a);
    	sc.deleteStudent(b);
    	
    	sc.deleteTeacher(k);
    	
    	System.out.println();
    	sc.showAllStudents();
    	System.out.println();
    	sc.showAllTeachers();
    	
    	
//    	System.out.println(a.getStudentNumber());
//    	System.out.println(b.getStudentNumber());
//    	System.out.println(h.getStudentNumber());
    }
}

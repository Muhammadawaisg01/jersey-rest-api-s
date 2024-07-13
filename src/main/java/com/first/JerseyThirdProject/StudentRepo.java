
package com.first.JerseyThirdProject;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

	static List<Student> students = new ArrayList<Student>() ;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	static List<Student> addStudents() {
		Student s1 = new Student(44, "AliC", 85, "ict", "comsats");
		Student s2 = new Student(45, "AliA", 83, "ict", "comsats");
		Student s3 = new Student(46, "AliB", 58, "ict", "comsats");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		System.out.println(students.toString());
		
		return students;	
	}
	
	static Student getStudent(int rollno) {
		
		for (Student student : students) {
			if(student.getRollno() == rollno) {
				return student;
			}
		}
	return null;
	}
	
	static Student createStudent(Student s ) {
		students.add(s) ;
		
		return s;
	}
	

	@Override
	public String toString() {
		return "StudentRepo [students=" + students + "]";
	}

	public static boolean deleteStudent(int rollno) {
		// TODO Auto-generated method stub
		
		Student s = getStudent(rollno); 
		
		return students.remove(s) ;
			
	}

	public static String deleteAllStudent() {
		// TODO Auto-generated method stub
		
		students = new ArrayList<Student>();
		return "Deleted Successfully";
	}

	public static boolean updateStudent(Student s ) {
		// TODO Auto-generated method stub
		
		Student student = getStudent(s.getRollno()); 
		
		if(student != null) {
			student.setName(s.getName()); 
			student.setMarks(s.getMarks());
			student.setCourse(s.getCourse());
			student.setUniversity(s.getUniversity());
			return true;
		}
		else {
			students.add(s);
			return false;
		}
	}
	
	
	
}

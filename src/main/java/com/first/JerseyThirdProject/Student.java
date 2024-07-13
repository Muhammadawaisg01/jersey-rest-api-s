package com.first.JerseyThirdProject;


public class Student {
	int rollno;
	String name;
	int marks;
	String course;
	String university;
	
	public Student() {
		super();
	}
	public Student(int rollno, String name, int marks, String course, String university) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.course = course;
		this.university = university;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
}

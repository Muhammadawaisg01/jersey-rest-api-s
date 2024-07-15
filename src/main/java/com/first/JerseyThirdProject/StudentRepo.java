
package com.first.JerseyThirdProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	
	static List<Student> addStudents() throws SQLException, ClassNotFoundException {
		
		String query = "select * from student";

		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		List<Student> list = new ArrayList<Student>();
		
		while(rs.next()) {

			System.out.println(rs.getInt("rollno")+"   "+rs.getString("fname")+"  "+rs.getString("lname")+"  "+rs.getString("sname"));
			Student s1 = new Student();
			s1.setRollno(rs.getInt("rollno")) ; 
			s1.setName(rs.getString("fname")); 
			s1.setCourse(rs.getString("lname"));
			s1.setUniversity(rs.getString("sname")); 
			s1.setMarks(rs.getInt("marks"));  

			list.add(s1);
		}

		return list;	
	}
	
	static Student getStudent(int rollno) throws ClassNotFoundException, SQLException {
		
		Student s1=null;
		String query = "select * from student where rollno = ?";
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, rollno);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			s1= new Student();
			s1.setRollno(rs.getInt("rollno")) ; 
			s1.setName(rs.getString("fname")); 
			s1.setCourse(rs.getString("lname"));
			s1.setUniversity(rs.getString("sname")); 
			s1.setMarks(rs.getInt("marks"));  
			return s1;
		}
		
//		for (Student student : students) {
//			if(student.getRollno() == rollno) {
//				return student;
//			}
//		}
	return null;
	}
	
	static Student createStudent(Student s ) throws SQLException, ClassNotFoundException {
		
		Student s1=null;
		String query = "insert into student (rollno,fname,lname,sname,marks) values ( ? , ?, ?, ? ,? )";
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, s.rollno);
		stmt.setString(2, s.getName());
		stmt.setString(3, s.getCourse());
		stmt.setString(4, s.getUniversity());
		stmt.setInt(5, s.getMarks());
		
		boolean var = stmt.execute();
		
//		students.add(s) ;
		return s;
	}
	

	@Override
	public String toString() {
		return "StudentRepo [students=" + students + "]";
	}

	public static boolean deleteStudent(int rollno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String query = "delete from student where rollno=?";
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, rollno);
		int bool = stmt.executeUpdate();
		
		return bool==1? true:false;
//		return students.remove(s) ;
			
	}

	public static String deleteAllStudent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "delete from student";
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		int bool = stmt.executeUpdate();
		
//		students = new ArrayList<Student>();
		return "Deleted Successfully";
	}

	public static boolean updateStudent(Student s ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String query = "Update student set fname=?, lname=?, sname=?, marks=? where rollno=?";
		Connection con = DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, s.getName());
		stmt.setString(2, s.getCourse());
		stmt.setString(3, s.getUniversity());
		stmt.setInt(4, s.getMarks());
		stmt.setInt(5, s.getRollno());
		int bool = stmt.executeUpdate();
		
		return bool==1?true:false;
	}
	
	
	
}

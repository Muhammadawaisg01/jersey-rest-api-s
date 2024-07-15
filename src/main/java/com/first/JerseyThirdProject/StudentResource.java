
package com.first.JerseyThirdProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.first.JerseyThirdProject.Student;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.FeatureContext;

@Path("student")
public class StudentResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent() throws SQLException, ClassNotFoundException {
		
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
		
		System.out.println("Hello Worldly");

//		Student s1 = new Student(44, "Ali", 88, "ict", "comsats");
		return list;

	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() throws ClassNotFoundException, SQLException {
		
		
		List<Student> students = StudentRepo.addStudents();

		return students;
	}

	@GET
	@Path("rollno/{rollno}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Student getStudent(@jakarta.ws.rs.PathParam("rollno") int rollno) throws ClassNotFoundException, SQLException {
		
		Student student = StudentRepo.getStudent(rollno);

		return student;
	}

	@POST
	@Path("createstudent")
	public Student createStudent(Student s) throws ClassNotFoundException, SQLException {

		StudentRepo.createStudent(s);
		return s;
	}

	@DELETE
	@Path("delete/{rollno}")
	public boolean deleteStudent(@PathParam("rollno") int rollno) throws ClassNotFoundException, SQLException {

		return StudentRepo.deleteStudent(rollno);
	}

	@DELETE
	@Path("deleteall")
	public String deleteAllStudent() throws ClassNotFoundException, SQLException {

		return StudentRepo.deleteAllStudent();
	}
	
	@PUT
	@Path("update")
	public String updateStudent(Student s) throws ClassNotFoundException, SQLException {

		 if(StudentRepo.updateStudent( s)) {
			 return "Student Updated Successfully";
		 }
		 else {
			 return "Failed to update, Created New Student";
		 }
			
	}

}

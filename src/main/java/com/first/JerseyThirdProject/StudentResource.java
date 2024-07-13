
package com.first.JerseyThirdProject;

import java.util.List;

import com.first.JerseyThirdProject.Student;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.FeatureContext;


@Path("student")
public class StudentResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Student getStudent() {

		System.out.println("Hello Worldly");
		
		
		Student s1 = new Student(44, "Ali", 88, "ict", "comsats");
		return s1 ; 
		
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Student> getStudents(){
		
		List<Student> students =  StudentRepo.addStudents();
		
		return students;
	}

	@GET
	@Path("/{rollno}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Student getStudent(@jakarta.ws.rs.PathParam("rollno") int rollno){
		
		Student student =  StudentRepo.getStudent(rollno);
		
		return student;
	}
	
	
}

package com.first.JerseyThirdProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
	public static Connection conn;
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String username="root";
		String pass="root"; 
		String url ="jdbc:mysql://localhost:3306/university";
		
		Class.forName("com.mysql.jdbc.Driver"); 
		try {
			Connection con = DriverManager.getConnection(url,username,pass);
			System.out.println("Database Connected SUccessfully");
			return con;			
		}catch(Exception ex) {
			System.out.println("Database Connection failed");
			return null;	
		}
	}
}

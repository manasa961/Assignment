package com.test.cms.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection conn;
	private static final String URL = "jdbc:mysql://localhost:3306/car_management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	
	public static Connection getConnection() {
		if(conn == null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(URL,USERNAME, PASSWORD); 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		
		return conn;
	}
}

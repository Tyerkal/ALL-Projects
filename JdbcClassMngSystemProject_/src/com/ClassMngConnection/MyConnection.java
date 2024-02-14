package com.ClassMngConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
private static Connection connection=null;
	
	private MyConnection() {
		
	}
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if(connection==null) {
			
			Class.forName("com.mysql.jdbc.driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc36","root","root");
			return connection;
		}
		
		return connection;
	}
	


}

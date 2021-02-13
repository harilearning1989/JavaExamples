package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDBConnection {

	//static reference to itself
	private static SingletonDBConnection instance = new SingletonDBConnection();
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASSWORD = "manager";
	public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver"; 
	
	//private constructor
	private SingletonDBConnection() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}	

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
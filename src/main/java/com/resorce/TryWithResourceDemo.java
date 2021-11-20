package com.resorce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResourceDemo {

	public static void main(String[] args) {

		withTryWithResource();
		withOutTryWithResource();
		withJdbcTryWithResource();

	}

	private static void withJdbcTryWithResource() {
			//Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost/mydatabase";
			System.out.println("Connection established......");
			//Registering the Driver
			try(Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
				Statement stmt = con.createStatement(); ) {
				try(ResultSet rs = stmt.executeQuery("select * from MyPlayers");){
					//Retrieving the data
					while(rs.next()) {
						System.out.print(rs.getInt("ID")+", ");
						System.out.print(rs.getString("First_Name")+", ");
						System.out.print(rs.getString("Last_Name")+", ");
						System.out.print(rs.getDate("Date_Of_Birth")+", ");
						System.out.print(rs.getString("Place_Of_Birth")+", ");
						System.out.print(rs.getString("Country"));
						System.out.println();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private static void withOutTryWithResource() {
		String mysqlUrl = "jdbc:mysql://localhost/mydatabase";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//Registering the Driver
		try {
			con = DriverManager.getConnection(mysqlUrl, "root", "password");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}   finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void withTryWithResource() {
		String mysqlUrl = "jdbc:mysql://localhost/mydatabase";
		try(Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
			Statement stmt = con.createStatement(); ) {
			try(ResultSet rs = stmt.executeQuery("select * from MyPlayers");){
				while(rs.next()) {
					System.out.print(rs.getInt("ID"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

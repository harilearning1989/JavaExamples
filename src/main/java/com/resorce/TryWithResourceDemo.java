package com.resorce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResourceDemo {

	public static void main(String[] args) {
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

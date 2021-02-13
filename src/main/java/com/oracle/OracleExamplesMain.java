package com.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleExamplesMain {
    public static void main(String[] args) {
        getJdbcData();
    }
    private static final String QUERY = "select * from EMPLOYEE_DATA";
    public static void getJdbcData() {

        try(Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {

            while(rs.next()){
                int id = rs.getInt("emp_Id");
                String name = rs.getString("emp_Name");
                String email = rs.getString("email");
                String country = rs.getString("salary");
                String password = rs.getString("status");
                System.out.println(id + "," +name+ "," +email+ "," +country+ "," +password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

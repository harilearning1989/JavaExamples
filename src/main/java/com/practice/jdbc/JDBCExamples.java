package com.practice.jdbc;

import com.oracle.DBConnection;

import java.sql.*;

public class JDBCExamples {

    private Connection connection;
    private Statement statement;

    public void getEmployee() throws SQLException {
        String query = "select * from EMPLOYEE_DATA";
        ResultSet rs = null;
        EmployeeDetails employee = null;
        try {
            connection = SingletonDBConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                employee = new EmployeeDetails();
                employee.setEmp_Id(rs.getInt(1));
                employee.setEmp_Name(rs.getString("Emp_Name"));
                employee.setEmail(rs.getString(3));
                //employee.setSalary(rs.getString("salary"));
                //employee.setStatus(rs.getc);
                System.out.println(employee.getEmail());
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }

    public void getEmployeeData() {

        System.out.println("=======================================================================");
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from EMPLOYEE_DATA");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "==" + rs.getString(2) + "==" + rs.getString(3) + "==" + rs.getString(4) + "==" + rs.getString(5) + "\n");
                System.out.println("=======================================================================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static final String QUERY = "select * from EMPLOYEE_DATA";

    public static void getJdbcData() {

        //using try-with-resources to avoid closing resources (boiler plate code)
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                int id = rs.getInt("emp_Id");
                String name = rs.getString("emp_Name");
                String email = rs.getString("email");
                String country = rs.getString("salary");
                String password = rs.getString("status");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCExamples.getJdbcData();
		/*JDBCExamples jDBCExamples=new JDBCExamples();
		try {
			jDBCExamples.getEmployee();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}

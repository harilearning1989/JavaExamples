package com.practice.jdbc;

public class EmployeeDetails {
	
	private int emp_Id;
	private String emp_Name;
	private String email;
	private int salary;
	private char status;
	
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

}

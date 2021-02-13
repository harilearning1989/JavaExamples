package com.practice.sort.multiple.sort;

public class EmployeeModel {
	
	private String name;
    private String jobTitle;
    private int age;
    private int salary;
 
    public EmployeeModel(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }
 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
        return String.format("%s\t%s\t%d\t%d", name, jobTitle, age, salary);
    }

}

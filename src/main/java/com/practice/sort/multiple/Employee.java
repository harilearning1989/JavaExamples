package com.practice.sort.multiple;

public class Employee {
    private String name;
    private int age;
    private int salary;
 
    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
 
    // getters and setters
 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        return String.format("%s\t%s\t%d", name, age, salary);
    }
}
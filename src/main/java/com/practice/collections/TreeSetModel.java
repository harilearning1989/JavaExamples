package com.practice.collections;

public class TreeSetModel implements Comparable<TreeSetModel> {

	private String name;
	private int salary;

	public TreeSetModel(String n, int s){
		this.name = n;
		this.salary = s;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString(){
		return "Name: "+this.name+"-- Salary: "+this.salary;
	}

	public int compareTo(TreeSetModel t){  
		if(salary==t.getSalary())  
			return 0;  
		else if(salary>t.getSalary())  
			return 1;  
		else  
			return -1;  
	}  
}
package com.practice.oops;

public class ClassOverloadParent {
	ClassOverloadParent(){
		System.out.println("super");
	}
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	void displayListParent(){
		System.out.println("Parent implementaion");
	}
	@SuppressWarnings("unused")
	private void privateSuper(){
		System.out.println("private super method");
	}

}

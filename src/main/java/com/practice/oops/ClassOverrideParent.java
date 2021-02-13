package com.practice.oops;

public class ClassOverrideParent {
	
	public void display(){
		System.out.println("parent display");
	}
	public void display1(){
		System.out.println("parent display1");
	}
	public static void staticMethod(){
		System.out.println("parent staticMethod");
	}
	public void show(){
		System.out.println("parent show");
		try{
			System.out.println("inside try");
		}catch(Exception e){
			System.out.println("inside catch");
		}
	}
	private void onlyParent(){
		
	}
}

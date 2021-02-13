package com.practice.oops;

public class SuperAndThisChild extends SuperAndThis {
	private SuperAndThisChild(){
		System.out.println("SuperAndThisChild");
	}
	SuperAndThisChild(int id){
		this();
		System.out.println("SuperAndThisChild int");
	}
	int id=1;
	void show(){
		System.out.println(id);
		System.out.println(super.id);
	}

	void thisExample(){
	}
	public static void main(String[] args) {
		SuperAndThisChild sc=new SuperAndThisChild(1);
		sc.show();
	}
}

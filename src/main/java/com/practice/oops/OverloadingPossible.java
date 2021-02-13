package com.practice.oops;

class ParentExample{

	public void show(){
		System.out.println("ParentExample show");
	}
	static void sample(){
		System.out.println("ParentExample sample ");
	}
	static void sample(int x){
		System.out.println("ParentExample sample int x "+x);
	}
}

public class OverloadingPossible extends ParentExample{

	//@Override  //if we add this it will show compile time error
	static void sample(int x){
		System.out.println("OverloadingPossible sample int x "+x);
	}
	public void show(){
		System.out.println("OverloadingPossible show");
	}
	public static void main(String[] args) {
		OverloadingPossible o=new OverloadingPossible();
		o.show();
		sample();
		sample(1);//here child class method will call
		ParentExample.sample(2);//here parent class method will invok
	}
}

package com.practice.oops;

public class OverLoadingExample {

	public static void printString(String s){
		System.out.println(s);
		System.out.println("string");
	}
	public static void printString(Object o){
		System.out.println(o);
		System.out.println("object");
	}
	public void callAnother(){
		String str="abc";
		passByVal(str);
		System.out.println(str);//here abc will print
	}

	private void passByVal(String str) {
		str="xyz";
		System.out.println(str);//here xyz will print 
	}
	public static void main(String[] args) {
		//printString(null);//here it will call execute printString(String s){  
		OverLoadingExample o=new OverLoadingExample();
		o.callAnother();
	}
}

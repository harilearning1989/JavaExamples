package com.practice.interview;

class SuperClass{
	public void printIt(){
		System.out.println("superClass");
	}
	public void printIt(boolean b){
		if(b){
			System.out.println("superClass2");
		}else{
			printIt();
		}
	}
}

public class SubClass  {
	
	public static void main(String[] args) {
		SuperClass superClass=new testSub();
		superClass.printIt();
		superClass.printIt(false);
	}
}

class testSub extends SuperClass{
	
	public void printIt(){
		System.out.println("subClass");
	}
}

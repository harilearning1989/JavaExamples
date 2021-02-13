package com.practice.oops;

public class ClassOverrideChild extends ClassOverrideParent{

	@Override
	public void display(){
		System.out.println("child display");
	}
	public static void staticMethod(){
		System.out.println("child staticMethod");
	}
	public static void staticMethod1(){
		System.out.println("child staticMethod");
	}
	public void show(){
		super.show();
		System.exit(1);
		System.out.println("child show");
	}
	public void onlyChild(){
		
	}
	public static void main(String[] args) {
		/*ClassOverrideParent c=new ClassOverrideChild();
		//c.display();
		c.display1();	
		ClassOverrideChild c1=new ClassOverrideChild();
		//c1.staticMethod();
		ClassOverrideParent.staticMethod();*/
		
		//ClassOverrideParent.staticMethod1();//we cannot call 
		ClassOverrideParent parentChild=new ClassOverrideParent();
		parentChild.show();
		parentChild.display();
		
	}
}

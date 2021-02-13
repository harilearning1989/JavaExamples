package com.practice.oops;

@SuppressWarnings({ "unused" })
public class ClassOverloadChild extends ClassOverloadParent{

	ClassOverloadChild(){
		super();
		System.out.println("Child");
	}
	//we cannot override or we cannot call private variables and methods in child class.
	//private only within class.using object of same class in other place also cannot access

	void displayListChild(){
		System.out.println("Child implementaion here parent method will not come");
		super.displayListParent();
		System.out.println("here parent also will come");
	}
	@Override
	void displayListParent(){
		
		System.out.println("Child implementaion here parent method will not come");
		super.displayListParent();
		System.out.println("here parent also will come");
	}
	void childToSuper(){
		System.out.println("calling private super method");
		//super.privateSuper();//compile time error
		super.setId(1);
		//super.id;//compile time error
		System.out.println("getting the id from super class======"+super.getId());
	}
	public static void main(String[] args) {
		/*ClassOverloadParent classOverloadParent=new ClassOverloadParent();
		//classOverloadParent.displayListParent();//here it will class only parent implementation
		//classOverloadParent.displayListChild(); compile time error
		ClassOverloadChild classOverloadChild=new ClassOverloadChild();
		//classOverloadChild.displayListParent();
		//classOverloadChild.displayListChild();
		classOverloadChild.childToSuper();
		ClassOverloadParent classOverloadParent1=new ClassOverloadParent();
		//classOverloadParent1.privateSuper();//compile time error
*/
		ClassOverloadParent v=new ClassOverloadChild();
	}
}
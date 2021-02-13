package com.practice.oops;

public class OverridePracticeChild extends OverridePracticeParent {

	//------------------------------------------------------------------------------------------------
	//if super class method is public sub class method should be public otherwise compile time error
	
	public void show(){
		System.out.println("child show");
		super.show();
	}
	
	/*private void show1(){
		System.out.println("compile time error occurs child show1");
	}
	void show1(){
		System.out.println("parent show1");
	}
	protected void show1(){
		System.out.println("parent show1");
	}*/
	//-----------------------------------------------------------------------------------------------------
	//=====================================================================================================
	void defaultMethod(){
		System.out.println("default to default works fine");
	}
	/*public void defaultMethod(){
		System.out.println("default to public works fine");
	}*/
	/*protected void defaultMethod(){
		System.out.println("default to protected works fine");
	}*/
	/*private void defaultMethod(){
		System.out.println("default to private compile time error");
	}*/
	//===========================================================================================================
	//-----------------------------------------------------------------------------------------------------------
	
	/*void protectedMethod(){
		System.out.println("protected to default compile time error");
	}*/
	
	/*private void protectedMethod(){
		System.out.println("protected to private compile time error ");
	}*/
	/*protected void protectedMethod(){
		System.out.println("protected to protected works fine");
	}*/
	public void protectedMethod(){
		System.out.println("protected to public works fine ");
	}
	
	public static void main(String[] args) {
		OverridePracticeParent parent=new OverridePracticeChild();
		parent.show();
	}
}

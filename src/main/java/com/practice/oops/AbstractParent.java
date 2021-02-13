package com.practice.oops;

public abstract class AbstractParent {
	public AbstractParent(){}
	
	//abstract class variables;
	
	private int iPrivate=0;
	int iDefault=1;
	static int iStatic=3;
	final int iFinal=4;
	//abstract class may or may not contain abstract methods
	//abstract methods must not contain implementation only declarations
	//void abstractSum(); in normal class we cannot have declarations we must implement

	/*compile time error
	abstract void abstractSum(){
	}*/
	//public void abstractSum(); here must declare abstract keyword
	public abstract void abstractSum();
	//private abstract void abstractSum5(); //compile time error
	//final abstract void abstractSum5();  //compile time error
	//default abstract void abstractSum5();  //compile time error
	//accepts only public protected
	abstract void abstractSumDefaultDeclaration();
	protected abstract void abstractSum1();
	protected abstract void abstractSumProtected1();
	
	abstract void abstractSumDefault1();
	
	public void abstractSumPublic(){
	}
	protected void abstractSumProtected(){
	}
	void abstractSumDefault(){
	}
	@SuppressWarnings("unused")
	private void abstractSumPrivate(){
	}
	public static void main(String[] args) {		
	}
}

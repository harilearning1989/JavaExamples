package com.practice.oops;

public interface OverLoadRideParent {
	//you cannot create object for interface and abstract class because these are not a complete classes
	//if allow to create object also no use because no implementation
	
	//by default interface variables are public static final
	int i=1;
	//int j;//you must assign the value here because it is final variable
	void overRide();
	void overRide(int i);
	//by default interface methods are public abstract no need to declare
	public void publicExample();
	
	/*the following methods are compile time errors
	protected void protectedExample();
	default void defaultExample();
	private void privateExample();*/
	
	default void defaultExample(){
		System.out.println("we can call this method in child class");
	}	
}

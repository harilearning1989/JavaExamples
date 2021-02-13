package com.practice.oops;

public interface ExceptionParentInterface {
	
	//if any class implemented this interface must override all the methods otherwise compile time error will throw in child method
	void getEmployeeList()throws Exception;
	void getEmployeeListById() throws ClassNotFoundException;
	
	static void updateEmployee(){
		//we can able to access this method using EncapsulationInterface because it is static method
		System.out.println("updateEmployee====");
	}
	default void updateEmployeeById(){
		System.out.println("the access specifier is default updateEmployee."
				+ "implementation is in interface====");
	}

	void getEmployeeListException()throws ClassCastException, ClassNotFoundException;
	void exceptionPriority()throws Exception;
}

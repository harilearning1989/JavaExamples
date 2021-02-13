package com.practice.oops;
public class ExceptionChild implements ExceptionParentInterface {

	@Override
	public void getEmployeeList()throws ArrayIndexOutOfBoundsException {
		System.out.println("here sub class method throwing run time exception so not declared in super method");
		ExceptionParentInterface.updateEmployee();
	}

	@Override
	public void getEmployeeListById()throws ClassNotFoundException {
		System.out.println("sub method throwing compile time excep so must be throw in super method otherwise compile time error");
	}
	/*@Override
	public void updateEmployee() {
		you cannot override static method
	}*/

	public void updateEmployee() {
		//this is not overriding 
	}

	@Override
	public void getEmployeeListException()throws ClassNotFoundException {
		System.out.println("super method throws run time exception sub method may or may not throw."
				+ "if super method throws compile time you must throw in sub class also");
	}
	@Override
	public void exceptionPriority() {
		System.out.println("super method throwing exception sub method may or throw same exception or its child exception");
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ExceptionChild encapsulationChild=new ExceptionChild();
		//you cannot do this
		//EncapsulationChild encapsulationInterface=new EncapsulationInterface();

		ExceptionChild encapsulationInterface=new ExceptionChild();
		//encapsulationChild.getEmployeeList();
		encapsulationInterface.updateEmployeeById();
	}
}

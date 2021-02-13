package com.practice.jdbc;

@FunctionalInterface
public interface FunctionalInterfaceTest {

	void doSomeWork();
	//void doSomeMoreWork();  
	//Functional interface having only one method if you add one more method it will show compile time error
	//even if you implement in sub class also it will show compile time error.
}

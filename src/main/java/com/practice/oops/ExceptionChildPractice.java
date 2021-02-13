package com.practice.oops;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionChildPractice extends ExceptionParent{

	void show(){
		//System.out.println("show parent");
		int a=2;
		int b=0;
		try{
			System.out.println(a/b);
			System.out.println("try===="+(a+b));	
			System.out.println("inside try===="+(a+b));
			
		}catch(Exception e){
			System.out.println(e);
			System.exit(1);
			System.out.println("inside catch===="+(a+b));
		}
		finally{
			System.out.println("finally====");
		}
	}
	public static void main(String[] args) throws Exception {
		ExceptionChildPractice exceptionChildPractice=new ExceptionChildPractice();
		exceptionChildPractice.show();
	}
}

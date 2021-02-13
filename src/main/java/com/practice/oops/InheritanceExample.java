package com.practice.oops;

public class InheritanceExample extends SubClass{

	public void multiplication(int x,int y){
		System.out.println(x+y);
	}
	public static void main(String[] args) {
		InheritanceExample ie=new InheritanceExample();
		ie.sum(2, 1);
		ie.concate(2,"hari");
		ie.multiplication(2,3);
	}
}
class SubClass{	
	public void sum(int x,int y){
		System.out.println(x+y);
	}
	public void concate(int x,String y){
		System.out.println(x+y);
	}
}

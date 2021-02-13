package com.practice.oops;

public interface InterfacePractice {
	int i=0;
	//private int iPrivate=1;//compile time error
	static int iStatic=2;
	final int iFinal=3;
	
	
	//copile time error
	/*void show(){
	}*/
	
	//private void show();//compile time error
	//protected void show();//compile time error
	public void show();

}
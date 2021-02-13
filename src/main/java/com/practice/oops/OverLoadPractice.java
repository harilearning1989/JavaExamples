package com.practice.oops;

public class OverLoadPractice {

	public void show(int x){
		System.out.println("type of parameter"+x);
	}
	private void show(String x){

	}
	protected void show(String x,int y){

	}
	void show(int x,String y){

	}
	public void show(int x,int y){

	}
	public static void showStatic(int x){

	}
	public static void showStatic(int x,int y){

	}
	public static void showStatic(int x,int y,String s){

	}
	int sum(int i){
		return i;
	}
	double sum(double d){
		return d;		
	}	

	public static void main(String[] args) {
		OverLoadPractice overLoadPractice=new OverLoadPractice();
		overLoadPractice.show(1);
		overLoadPractice.show("hari");
		overLoadPractice.show("hari",1);
		overLoadPractice.show(1,"hari");
		overLoadPractice.show(1,2);
		showStatic(1);
		showStatic(1,2);
		showStatic(1,2,"hari");
		System.out.println(overLoadPractice.sum(4));
		System.out.println(overLoadPractice.sum(12.2));
	}
}

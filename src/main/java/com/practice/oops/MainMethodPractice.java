package com.practice.oops;

public class MainMethodPractice {

	//possible ways for declaring constructor

	/*private MainMethodPractice(){
		System.out.println("Default main method");
	}*/
	/*protected MainMethodPractice(){
		System.out.println("Default main method");
	}*/

	//not possible for declaring constructor

	/*static MainMethodPractice(){
		System.out.println("compile time error");
	}
	synchronized MainMethodPractice(){
		System.out.println("compile time error");
	}
	final MainMethodPractice(){
		System.out.println("Default main method");
	}
	*/

	//possible ways for declaring main method

	public static void main(String args[]) {//if we remove anything from this method it will not run
		System.out.println("removed public here we cannot run");
		MainMethodPractice mp=new MainMethodPractice();
	}
	/*public static void main(String...x) {//if we remove one dot it will show compiletime error
		System.out.println("Default main method");
		//main(1);
	}*/
	/*public static void main(int x) {
		System.out.println(x);
	}*/
	/*public static void main(String[] args) {
		System.out.println("Default main method");
	}*/
	/*public static void main(String args[]) {
		System.out.println("array changed  []");
	}*/
	/*public final static void main(String args[]) {
		System.out.println("added final");
	}*/
	/*public final synchronized static void main(String args[]) {
		System.out.println("added final and synchronized");
	}*/
	/*public synchronized static void main(String args[]) {
		System.out.println("synchronized");
	}*/

	//not possible ways for declaring main method

	/*public synchronized static void main1(String args[]) {
		System.out.println("modified main to main1 this method treated as a normal method not shows any error");
	}*/
	/*public void main(String args[]) {
		System.out.println("removed static here we cannot run because this method treated as a normal method");
	}*/
	/*void main(String args[]) {
		System.out.println("removed public and static here we cannot run because this method treated as a normal method");
	}*/
	/*static void main(String args[]) {
		System.out.println("removed public here we cannot run because this method treated as a normal method");
	}*/
	/*public static int main(String args[]) {
		System.out.println("removed public here we cannot run because this method treated as a normal method");
		return 1;
	}*/
	/*private static void main(String args[]) {
		System.out.println("removed public here we cannot run because this method treated as a normal method");
	}*/
}
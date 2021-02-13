package com.practice.oops;

@SuppressWarnings("finally")
public class BlocksExample {

	public static int blockExample(){
		try{
			System.out.println("try");
			return 1;
		}catch(Exception e){
			return 2;
		}finally{
			System.out.println("finally");
			return 3;
		}
	}
	public static int blockExample1(){
		try{
			return 1;
		}catch(Exception e){
			return 2;
		}
	}

	public static void main(String[] args) {
		System.out.println(blockExample());//here the output is finally  3
		System.out.println(blockExample1());//here the output is 1
	}
}

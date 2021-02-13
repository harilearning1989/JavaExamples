package com.dataType;

public class DataTypesExamples {
	String str;int i;boolean b;char c;float f;double d;long l;
	public void defaultValuesOfDataTypes(){
		System.out.println(str+"===="+i+"===="+b+"====");
	}

	public static void exampleShow(){
		String[] str={"Hari","Reddy"};
		System.out.println(str.length);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
		int[] firstArray={1,2,3,4,4};
		int[] secondArray={33,44};
		firstArray=secondArray;
		secondArray=firstArray;
		
		System.out.println(firstArray+"===="+secondArray);
		for(int i=0;i<firstArray.length;i++){
			System.out.println("exampleShow=====firstArray===="+firstArray[i]);
		}
		for(int i=0;i<secondArray.length;i++){
			System.out.println("exampleShow=====secondArray===="+secondArray[i]);
		}
	}

	public static void main(String[] args) {
		exampleShow();
	}
}

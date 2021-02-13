package com.practice.arry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayPracticed {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void arrayExample(){
		int[] myList = {1, 2, 3,4, 3,5,6,5,4,3,5};
		for(int i=0;i<myList.length;i++){
		//	System.out.println("just printing the numbers===="+myList[i]);
		}

		System.out.println("========================");

		List wordList = Arrays.asList(myList);  
		for(int i=0;i<wordList.size();i++){
			System.out.println(wordList.get(i));
		}
		Iterator iterate=wordList.iterator();
		while(iterate.hasNext()){
			System.out.println("iterate example-============="+iterate.next());
		}
		Set set=new HashSet(wordList);
		System.out.println("Unique Numbers from array======"+set);
		for (int i=0;i<set.size();i++) {
		    //System.out.println("Unique Numbers from array======"+set);
		}
		
		 /*Iterator<String> it = set.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next());
	     }*/
		
		List list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for(int j=0;j<list.size();j++){
			System.out.println("the items==="+list.get(j));
		}
	}
	public static void remDupWithoutListFromArray(){
		int[] myList = {1, 2, 3,4, 3,5,6,5,4,3,5};
		
		Set set=new HashSet();
		
		for(int i=0;i<myList.length;i++){
			set.add(myList[i]);
		}
		//1 example 1
		//System.out.println(set);
		//or
		//2 example 2
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void minAndMaxValue(){
		int arr[]={1,3,4,5,2,0,5,6,8,34};
		int min=arr[0];
		int max=arr[0];
		
		for(int i=1;i<arr.length;i++){
			if(min>arr[i]){
				min=arr[i];
			}
			if(max<arr[i]){
				max=arr[i];
			}
		}	
		System.out.println("the min value is==="+min+"===the maximum value is==="+max);
	}
	public static void arraySorting(){
		String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"}; 

		Arrays.sort(fruits);

		int i=0;
		for(String temp: fruits){
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}

	public static void main(String[] args) {
		//ArrayPracticed.arrayExample();
		//ArrayPracticed.remDupWithoutListFromArray();
		minAndMaxValue();
	}
}

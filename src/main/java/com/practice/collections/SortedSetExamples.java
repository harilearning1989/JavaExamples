package com.practice.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExamples {

	public static void main(String[] args) {
		System.out.println("SortedSetExamples===============");
		sortedSetMethods();
	}

	private static void sortedSetMethods() {
		SortedSet<String> set = new TreeSet<>();   
		set.add("Audi");  
		set.add("BMW");  
		set.add("Mercedes");  
		set.add("Ford");  
		for (String str : set) {  
			System.out.println(str);  
		}  
		System.out.println("First   Example====" + set.first());     
		System.out.println("Last    Example====" + set.last());  
		System.out.println("HeadSet Example====" + set.headSet("Ford"));  
		System.out.println("TailSet Example====" + set.tailSet("Audi"));  
		System.out.println("SubSet  Example====" + set.subSet("BMW", "Mercedes"));  
	}    
}

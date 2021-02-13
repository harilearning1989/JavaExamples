package com.practice.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Java8Features implements FunctionalInterfaceTest {
	
	public void callJavaScript(){
		  ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	      ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
			
	      String name = "Mahesh";
	      Integer result = null;
	      
	      try {
	         nashorn.eval("print('" + name + "')");
	         result = (Integer) nashorn.eval("10 + 2");
	         
	      }catch(ScriptException e){
	         System.out.println("Error executing script: "+ e.getMessage());
	      }
	      
	      System.out.println(result.toString());
	   }

	@Override
	public void doSomeWork() {

		System.out.println("Java compiler compiles lambda expressions and convert them into private method of the class.");
		System.out.println("===================================");

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		System.out.println("Print all numbers:");
		evaluate(list, (n)->true);

		System.out.println("Print no numbers:");
		evaluate(list, (n)->false);

		System.out.println("Print even numbers:");
		evaluate(list, (n)-> n%2 == 0 );

		System.out.println("Print odd numbers:");
		evaluate(list, (n)-> n%2 == 1 );

		System.out.println("Print numbers greater than 5:");
		evaluate(list, (n)-> n > 5 );

		System.out.println("===================================");
	}

	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for(Integer n: list)  {
			if(predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}

	public void lambdaSorting(){
		List<String> names1 = new ArrayList<String>();
		names1.add("Mahesh ");
		names1.add("Suresh ");
		names1.add("Ramesh ");
		names1.add("Naresh ");
		names1.add("Kalpesh ");

		List<String> names2 = new ArrayList<String>();
		names2.add("Mahesh ");
		names2.add("Suresh ");
		names2.add("Ramesh ");
		names2.add("Naresh ");
		names2.add("Kalpesh ");

		System.out.println("Sort using Java 7 syntax: ");

		sortUsingJava7(names1);

		System.out.println(names1);
		System.out.println("Sort using Java 8 syntax: ");

		sortUsingJava8(names2);

		System.out.println(names2);
	}

	//sort using java 7
	private void sortUsingJava7(List<String> names){   
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	//sort using java 8
	private void sortUsingJava8(List<String> names){
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
	public static void main(String[] args) {
		Java8Features java8Features=new Java8Features();
		/*java8Features.doSomeWork();
		java8Features.lambdaSorting();*/
		java8Features.callJavaScript();
	}
}
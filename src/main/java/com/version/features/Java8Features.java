package com.version.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Features {

	public static void features(){

		Map<String, Integer> stringItems = new HashMap<>();
		stringItems.put("A", 10);
		stringItems.put("B", 20);
		stringItems.put("C", 30);
		stringItems.put("D", 40);
		stringItems.put("E", 50);
		stringItems.put("F", 60);

		for (Map.Entry<String, Integer> entry : stringItems.entrySet()) {
			System.out.println("stringItems using for loop==: " + entry.getKey() + " stringItems Count : " + entry.getValue());
		}

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k,v)->System.out.println("Item java8 features: " + k + " Count : " + v));

		/*items.forEach((k,v)->{
			System.out.println("Item java8 features: " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});*/
	}
	public static void lambdaExaple(){
		List<ProductModel> list=new ArrayList<ProductModel>();  
		list.add(new ProductModel(1,"Samsung A5",17000f));  
		list.add(new ProductModel(3,"Iphone 6S",65000f));  
		list.add(new ProductModel(2,"Sony Xperia",25000f));  
		list.add(new ProductModel(4,"Nokia Lumia",15000f));  
		list.add(new ProductModel(5,"Redmi4 ",26000f));  
		list.add(new ProductModel(6,"Lenevo Vibe",19000f));  

		// using lambda to filter data  
		Stream<ProductModel> filtered_data = list.stream().filter(p -> p.price > 2000);  

		// using lambda to iterate through collection  
		filtered_data.forEach(product -> System.out.println(product.name+":===== "+product.price));  

		// implementing lambda expression  
		Collections.sort(list,(p1,p2)->{  
			return p1.name.compareTo(p2.name);  
		});  
		list.forEach(product -> System.out.println(product.name+":===== "+product.price));
		/*for(ProductModel p:list){  
			System.out.println(p.id+"==="+p.name+"===="+p.price);  
		}*/  
	}

	public static void parralelSort(){
		// Creating an integer array   
		int[] arr = {5,8,1,0,6,9};  
		// Iterating array elements  
		for (int i : arr) {  
			System.out.print(i+" ");  
		}  
		// Sorting array elements parallel  
		Arrays.parallelSort(arr);  
		System.out.println("\nArray elements after sorting===========================");  
		// Iterating array elements  
		for (int i : arr) {  
			System.out.print(i+" ");  
		}  
	}

	public static void stringJoin(){
		StringJoiner joinNames1 = new StringJoiner(","); // passing comma(,) as delimiter   

		// Adding values to StringJoiner  
		joinNames1.add("Rahul");  
		joinNames1.add("Raju");  
		joinNames1.add("Peter");  
		joinNames1.add("Raheem");  

		System.out.println("\n stringJoin======"+joinNames1); 

		StringJoiner joinNames = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   

		// Adding values to StringJoiner  
		joinNames.add("Rahul");  
		joinNames.add("Raju");  
		joinNames.add("Peter");  
		joinNames.add("Raheem");  

		System.out.println(joinNames.length());  
	}
	public static void collectors(){
		List<ProductModel> productsList = new ArrayList<ProductModel>();  
		//Adding Products  
		productsList.add(new ProductModel(1,"HP Laptop",25000f));  
		productsList.add(new ProductModel(2,"Dell Laptop",30000f));  
		productsList.add(new ProductModel(3,"Lenevo Laptop",28000f));  
		productsList.add(new ProductModel(4,"Sony Laptop",28000f));  
		productsList.add(new ProductModel(5,"Apple Laptop",90000f));  
		
		Double average = productsList.stream().collect(Collectors.averagingDouble(p->p.price));  
		
		System.out.println("Average price is: "+average);  
	}

	public static void main(String[] args) {
		//features();
		//lambdaExaple();
		parralelSort();
		stringJoin();
		collectors();
	}
}
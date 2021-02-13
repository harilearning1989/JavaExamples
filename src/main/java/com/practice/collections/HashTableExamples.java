package com.practice.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableExamples {
	
	public static void main(String[] args) {
		Map map=new Hashtable();
		map.put(1,2);
		//map.put(null,3);
		map.put(2,"null");
		map.put("null","null");
		//map.put("null");//compile time error
		
		System.out.println(map);
	}
}

package com.practice.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		sortedMapMethods();
	}

	private static void sortedMapMethods() {
		SortedMap<Integer, String> sm = new TreeMap<Integer, String>(); 
		sm.put(2, "practice"); 
		sm.put(3, "quiz"); 
		sm.put(5, "code"); 
		sm.put(4, "contribute"); 
		sm.put(1, "geeksforgeeks"); 
		Set<Integer> s = sm.keySet(); 

		Iterator<Integer> i = s.iterator(); 
		while (i.hasNext()) { 
			int value = i.next();
			System.out.println("Key : " + value + "  value : " + sm.get(value)); 
		}
		SortedMap<Integer, String> subMap = sm.subMap(2,4);
		System.out.println(subMap);
		SortedMap<Integer, String> tailMap = sm.tailMap(3);
		System.out.println(tailMap);
		SortedMap<Integer, String> headMap = sm.headMap(3);
		System.out.println(headMap);
		int firstKey = (Integer) sm.firstKey();
		System.out.println(firstKey);
		int lastKey = (Integer) sm.lastKey();
		System.out.println(lastKey);
	}

}

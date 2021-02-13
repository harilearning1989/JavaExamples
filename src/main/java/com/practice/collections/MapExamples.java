package com.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MapExamples {

	public static void identityHashMaps(){
		IdentityHashMap<String, String> identityMap = new IdentityHashMap<String, String>();

		identityMap.put("hari", "bravia");
		identityMap.put(new String("hari"), "mobile");

		//size of identityMap should be 2 here because two strings are different objects
		System.out.println("Size of IdentityHashMap: " + identityMap.size());
		System.out.println("IdentityHashMap: " + identityMap);

		identityMap.put("hari", "videogame");

		//size of identityMap still should be 2 because "hari" and "hari" is same object
		System.out.println("Size of IdentityHashMap: " + identityMap.size());
		System.out.println("IdentityHashMap: " + identityMap);
		System.out.println("===========================================");
		HashMap hashMap=new HashMap();
		hashMap.put("hari", "bravia");
		hashMap.put(new String("hari"), "mobile");
		
		System.out.println("Size of HashMap: " + hashMap.size());//output is 1
		System.out.println("HashMap: " + hashMap);	//output is hari mobile	
		
		Iterator i=hashMap.entrySet().iterator();
		while(i.hasNext()){
			Entry e=(Entry)i.next();
			System.out.println(e.getKey()+"===="+e.getValue());
		}
	}

	public static void hashMapAndWeakHashMap(){

		// Created HashMap and WeakHashMap objects

		Map hashmapObject = new HashMap();
		Map weakhashmapObject = new WeakHashMap();

		// Created HashMap and WeakHashMap keys

		String hashmapKey = new String ("hashmapkey");
		String weakhashmapKey = new String ("weakhashmapkey");

		// Created HashMap and WeakHashMap values

		String hashmapValue = "hashmapvalue";
		String weakhashmapValue = "weakhashmapvalue";  

		// Putting key and value in HashMap and WeakHashMap Object

		hashmapObject.put(hashmapKey ,hashmapValue); 
		weakhashmapObject.put(weakhashmapKey ,weakhashmapValue); 

		// Print HashMap and WeakHashMap Object : Before Garbage Collection

		System.out.println("HashMap before Garbage Collected :"+ hashmapObject);
		System.out.println("WeakHashMap before Garbage Collected :"+ weakhashmapObject);

		// Set HashMap and WeakHashMap Object keys to null

		hashmapKey = null;  
		weakhashmapKey = null;

		// Calling Garbage Collection
		System.gc(); 

		// Print HashMap and WeakHashMap Object : After Garbage Collection

		System.out.println("HashMap after Garbage Collected :"+ hashmapObject);
		System.out.println("WeakHashMap after Garbage Collected :"+ weakhashmapObject); 
	}

	public static void addWays(){
		Map map=new HashMap();
		map.put(1,"hari");
		map.put(2,"hari111");

		System.out.println(map.size());
		Iterator it=map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next()+"===="+map.get(it.next()));
		}
		List list=new ArrayList(map.keySet());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)+"==="+map.get(list.get(i)));
		}
	}
	//========================12/11/2016========
	public static void findMaxAndMinValue(){
		Map map=new HashMap();
		map.put(1,3);
		map.put(2,4);
		map.put("3",2);
		map.put(4,6);
		map.put(5,4);

		List listValues=new ArrayList(map.values());
		System.out.println("maximum value======="+Collections.max(listValues));
		System.out.println("minimum value======="+Collections.min(listValues));

		List listKeys=new ArrayList(map.keySet());
		System.out.println("maximum key======="+Collections.max(listKeys));
		System.out.println("maximum key======="+Collections.max(listKeys));
	}

	public static void sortPojo(){

		List<SortModel> listSortModels = new ArrayList<SortModel>();
		listSortModels.add(new SortModel("Tom", "Developer", 45, 80000));
		listSortModels.add(new SortModel("Sam", "Designer", 30, 75000));
		listSortModels.add(new SortModel("Bob", "Designer", 45, 134000));
		listSortModels.add(new SortModel("Peter", "Programmer", 25, 60000));
		listSortModels.add(new SortModel("Tim", "Designer", 45, 130000));
		listSortModels.add(new SortModel("Craig", "Programmer", 30, 52000));
		listSortModels.add(new SortModel("Anne", "Programmer", 25, 51000));
		listSortModels.add(new SortModel("Alex", "Designer", 30, 120000));
		listSortModels.add(new SortModel("Bill", "Programmer", 22, 30000));
		listSortModels.add(new SortModel("Samuel", "Developer", 28, 80000));
		listSortModels.add(new SortModel("John", "Developer", 35, 67000));
		listSortModels.add(new SortModel("Patrick", "Developer", 35, 140000));
		listSortModels.add(new SortModel("Alice", "Programmer", 35, 80000));
		listSortModels.add(new SortModel("David", "Developer", 35, 99000));
		listSortModels.add(new SortModel("Jane", "Designer", 30, 82000));

		System.out.println("*** Before sorting:");

		for (SortModel emp : listSortModels) {
			System.out.println(emp);
		}

		//Collections.sort(listSortModels, new ComparatorSort());

		System.out.println("\n*** After sorting:");

		for (SortModel emp : listSortModels) {
			System.out.println(emp);
		}
	}

	public static void mapSortByKey(){
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "A");
		hmap.put(11, "C");
		hmap.put(4, "Z");
		hmap.put(77, "Y");
		hmap.put(9, "P");
		hmap.put(66, "Q");
		hmap.put(0, "R");

		List list=new ArrayList(hmap.keySet());
		Collections.sort(list);
		//Collections.reverse(list);//for reverse order
		for(int i=0;i<list.size();i++){
			System.out.println("the keys are==="+list.get(i)+"====the value is==="+hmap.get(list.get(i)));
		}
	}

	public static void mapSortByValue(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
		map.put("A", 1);
		map.put("B", 4);
		map.put("E", 1);
		map.put("C", 2);
		map.put("D", 3);
		System.out.println("unsorted map: " + map);
		sorted_map.putAll(map);
		System.out.println("results: " + sorted_map);
	}

	public static void iterateMap(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 40);
		map.put(4, 50);
		map.put(6, 20);//here duplicate key is there so it will overrides the existing one
		map.put(6, 40);
		map.put(7, 10);

		System.out.println(map.containsValue(140));

		Iterator i = map.entrySet().iterator(); 
		while(i.hasNext()) {
			Entry key = (Entry) i.next();
			System.out.println("key===="+key.getValue()+"===value==="+key.getKey());
		}

		/*List<Integer> listKey=new ArrayList<Integer>(map.keySet());
		List<Integer> listValue=new ArrayList<Integer>(map.values());
		Set<Integer> setKeys=new HashSet<Integer>(map.keySet());
		Set<Integer> setValues=new HashSet<Integer>(map.values());*/

		List<Integer> list=new ArrayList<Integer>(map.keySet());
		Collections.reverse(list);

		for(int j=0;j<list.size();j++){
			System.out.println("The key is==="+list.get(j)+"==the value is==="+(map.get(list.get(j)))/2);
		}

		/*
		System.out.println("===========seperating keys and values==============");
		for (Integer key : map.keySet()) {
			System.out.println("Key = " + key);
		}

		for (Integer value : map.values()) {
			System.out.println("Value = " + value);
		}
		//Java 8 only, forEach and Lambda. recommend!
		System.out.println("\n=========Java 8 Getting keys and values==========");
		map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));

		 */
	}
	public static void arrayToMap(){
		ArrayList<String> al = new ArrayList<String>();    //init first,just for test
		al.add("aaa");
		al.add("bbb");
		al.add("ccc");
		al.add("aaa");
		al.add("ccc");

		Map<String,Integer> map = new HashMap<String, Integer>();
		/*for(int i=0;i<al.size();i++){            
			Integer count = map.get(al.get(i));       
			map.put(al.get(i), count==null?1:count+1);   //auto boxing and count
		}*/
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i)+"===="+i);
			map.put(al.get(i), i);
		}
	}
	public static void reverseMap(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("1", "Anil");
		map.put("2", "Deven");
		map.put("3", "sanjay");
		map.put("4", "sanjay");
		map.put("5", "Raj");
		map.put("6", "sanjay");

		List<String> list=new ArrayList<String>(map.keySet());
		Collections.reverse(list);

		for(int j=0;j<list.size();j++){
			System.out.println("The key is==="+list.get(j)+"==the value is==="+map.get(list.get(j)));
		}
	}

	public static void conCurrentExamples(){
		List<String> myList = new CopyOnWriteArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println("List Value:"+value);
			if(value.equals("3")){
				myList.remove("4");
				myList.add("6");
				myList.add("7");
			}
		}
		System.out.println("List Size:"+myList.size());

		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			System.out.println("Map Value:"+myMap.get(key));
			if(key.equals("1")){
				myMap.remove("3");
				myMap.put("4", "4");
				myMap.put("5", "5");
			}
		}

		System.out.println("Map Size:"+myMap.size());
	}

	public static void removeDuplicateValues(){
		Map<Integer,String> uniqueMap=new HashMap<Integer,String>();
		Map<Integer,String> mainMap=new HashMap<Integer,String>();

		mainMap.put(99,"Vijay");  
		mainMap.put(100,"Amit");  
		mainMap.put(101,"Vijay");  
		mainMap.put(102,"Rahul");  
		mainMap.put(103,"Rahul"); 

		Iterator i = mainMap.keySet().iterator(); 
		while(i.hasNext()) {
			Integer key = (Integer) i.next();
			String value = (String) mainMap.get(key);
			//System.out.println(key + " = " + value);
			if(!uniqueMap.containsValue(value)){
				uniqueMap.put(key ,value );
			}
		}
		System.out.println(uniqueMap);
	}
	public static void main(String[] args) {
		/*findMaxAndMinValue();
		sortPojo();
		mapSortByKey();
		mapSortByValue();
		iterateMap();
		arrayToMap();
		reverseMap();
		removeDuplicateValues();
		conCurrentExamples();*/
		//iterateMap();
		//addWays();
		identityHashMaps();
	}
}

class ValueComparator implements Comparator<String> {
	Map<String, Integer> base;
	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
	}
	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(String a, String b) {
		if (base.get(a) <= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}

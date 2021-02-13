package com.practice.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConCurrentException {

	public static void conCurrent(){

		//List<String> myList = new ArrayList<String>();
		List<String> myList = new CopyOnWriteArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
	//	myList.add("5");
		System.out.println(myList.size());
		System.out.println("================"+myList.get(myList.size()-1));
		Iterator<String> it = myList.iterator();
		while(it.hasNext()){
			String value = it.next();
			if(value.equals("3")) myList.remove(value);
		}
		//System.out.println(myList);
	}

	public static void main(String[] args) {
		ConCurrentException.conCurrent();
	}
}
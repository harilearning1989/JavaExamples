package com.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparatorTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]){  

		List al=new ArrayList();  
		al.add(new StudentModel(101,"Vijay",23));  
		al.add(new StudentModel(106,"Ajay",27));  
		al.add(new StudentModel(105,"Jai",21));  

		System.out.println("Sorting by Name...");  

		Collections.sort(al,new NameComparator()); 
		
		Iterator itr=al.iterator();  
		while(itr.hasNext()){  
			StudentModel st=(StudentModel)itr.next();  
			System.out.println(st.rollno+" "+st.name+" "+st.age);  
		}  

		System.out.println("sorting by age...");  

		Collections.sort(al,new AgeComparator());
		
		Iterator itr2=al.iterator();  
		while(itr2.hasNext()){  
			StudentModel st=(StudentModel)itr2.next();  
			System.out.println(st.rollno+" "+st.name+" "+st.age);  
		}  
	}  
}

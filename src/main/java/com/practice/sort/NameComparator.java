package com.practice.sort;

import java.util.*;  
@SuppressWarnings("rawtypes")
class NameComparator implements Comparator{  
	public int compare(Object o1,Object o2){  
		StudentModel s1=(StudentModel)o1;  
		StudentModel s2=(StudentModel)o2;  

		return s1.name.compareTo(s2.name);  
	}  
}  
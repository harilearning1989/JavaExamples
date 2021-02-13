package com.practice.sort;

import java.util.*;  
@SuppressWarnings("rawtypes")
class AgeComparator implements Comparator{  
	public int compare(Object o1,Object o2){  
		StudentModel s1=(StudentModel)o1;  
		StudentModel s2=(StudentModel)o2;  

		if(s1.age==s2.age)  
			return 0;  
		else if(s1.age>s2.age)  
			return 1;  
		else  
			return -1;  
	}  
}  

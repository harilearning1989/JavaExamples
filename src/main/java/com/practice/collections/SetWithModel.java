package com.practice.collections;

import java.util.HashSet;
import java.util.Set;

public class SetWithModel {

	public static void setWithModelExample(){
		Set<SetWithModelClass> set=new HashSet<SetWithModelClass>();
		
		SetWithModelClass s1=new SetWithModelClass(1,"abc");
		SetWithModelClass s2=new SetWithModelClass(2,"abc");
		SetWithModelClass s3=new SetWithModelClass(2,"abc");
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		
		System.out.println(set.size());
		
	}

	public static void main(String[] args) {
		setWithModelExample();
	}
}

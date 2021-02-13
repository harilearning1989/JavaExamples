package com.practice.collections;

import java.util.Comparator;

public class TreeSetSalaryCompare implements Comparator<TreeSetModel>{

	public int compare(TreeSetModel e1, TreeSetModel e2) {
		if(e1.getSalary() > e2.getSalary()){
			return 1;
		} else {
			return -1;
		}
	}
}

package com.practice.collections;

import java.util.Comparator;

public class TreeSetNameCompare implements Comparator<TreeSetModel>{

	public int compare(TreeSetModel e1, TreeSetModel e2) {
		return e1.getName().compareTo(e2.getName());
	}
}  

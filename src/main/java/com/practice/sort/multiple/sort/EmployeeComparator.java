package com.practice.sort.multiple.sort;

import java.util.Comparator;

 
public class EmployeeComparator implements Comparator<EmployeeModel> {
 
    @Override
    public int compare(EmployeeModel o1, EmployeeModel o2) {
		/*
		 * return new CompareToBuilder() .append(o1.getJobTitle(), o2.getJobTitle())
		 * .append(o1.getAge(), o2.getAge()) .append(o1.getSalary(),
		 * o2.getSalary()).toComparison();
		 */
    	return 10;
    }
}
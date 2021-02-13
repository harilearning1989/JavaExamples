package com.practice.sort.multiple;

import java.util.Comparator;

/**
 * This comparator compares two employees by their job titles.
 * @author www.codejava.net
 *
 */
public class EmployeeNameComparator implements Comparator<Employee> {
 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        //return emp1.getJobTitle().compareTo(emp2.getJobTitle());
        return emp1.getName().compareTo(emp2.getName());
    }
}

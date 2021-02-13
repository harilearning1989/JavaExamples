package com.practice.sort.multiple.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleFieldsSorting {
	
	//http://www.codejava.net/java-core/collections/sorting-a-list-by-multiple-attributes-example

	public static void main(String[] args) {

		System.out.println("===== SORTING BY MULTIPLE ATTRIBUTES =====");

		List<EmployeeModel> listEmployees = new ArrayList<EmployeeModel>();

		listEmployees.add(new EmployeeModel("Tom", "Developer", 45, 80000));
		listEmployees.add(new EmployeeModel("Sam", "Designer", 30, 75000));
		listEmployees.add(new EmployeeModel("Bob", "Designer", 45, 134000));
		listEmployees.add(new EmployeeModel("Peter", "Programmer", 25, 60000));
		listEmployees.add(new EmployeeModel("Tim", "Designer", 45, 130000));
		listEmployees.add(new EmployeeModel("Craig", "Programmer", 30, 52000));
		listEmployees.add(new EmployeeModel("Anne", "Programmer", 25, 51000));
		listEmployees.add(new EmployeeModel("Alex", "Designer", 30, 120000));
		listEmployees.add(new EmployeeModel("Bill", "Programmer", 22, 30000));
		listEmployees.add(new EmployeeModel("Samuel", "Developer", 28, 80000));
		listEmployees.add(new EmployeeModel("John", "Developer", 35, 67000));
		listEmployees.add(new EmployeeModel("Patrick", "Developer", 35, 140000));
		listEmployees.add(new EmployeeModel("Alice", "Programmer", 35, 80000));
		listEmployees.add(new EmployeeModel("David", "Developer", 35, 99000));
		listEmployees.add(new EmployeeModel("Jane", "Designer", 30, 82000));

		System.out.println("*** Before sorting:");

		for (EmployeeModel emp : listEmployees) {
			System.out.println(emp);
		}

		Collections.sort(listEmployees, new EmployeeComparator());

		System.out.println("\n*** After sorting:");

		for (EmployeeModel emp : listEmployees) {
			System.out.println(emp);
		}
	}
}

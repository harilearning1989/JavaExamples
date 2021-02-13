package com.practice.sort.multiple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleFieldsSorting {

	public static void main(String[] args) {

		System.out.println("===== SORTING BY MULTIPLE ATTRIBUTES =====");

		List<Employee> listEmployees = new ArrayList<Employee>();

		listEmployees.add(new Employee("Tom", 45, 80000));
		listEmployees.add(new Employee("Sam", 30, 75000));
		listEmployees.add(new Employee("Bob", 45, 134000));
		listEmployees.add(new Employee("Peter", 25, 60000));
		listEmployees.add(new Employee("Tim", 45, 130000));
		listEmployees.add(new Employee("Craig", 30, 52000));
		listEmployees.add(new Employee("Anne", 25, 51000));
		listEmployees.add(new Employee("Alex", 32, 1200011));
		listEmployees.add(new Employee("Alex", 30, 1200011));
		listEmployees.add(new Employee("Bill", 22, 30000));
		listEmployees.add(new Employee("Samuel", 28, 80000));
		listEmployees.add(new Employee("John", 35, 67000));
		listEmployees.add(new Employee("Patrick", 35, 140000));
		listEmployees.add(new Employee("Alice", 35, 80000));
		listEmployees.add(new Employee("David", 35, 99000));
		listEmployees.add(new Employee("Jane", 30, 82000));

		/*System.out.println("*** Before sorting:");

		for (Employee emp : listEmployees) {
			System.out.println(emp);
		}*/

		Collections.sort(listEmployees, new EmployeeChainedComparator(
				new EmployeeNameComparator(),
				new EmployeeSalaryComparator(),
				new EmployeeAgeComparator()
				));

		System.out.println("\n*** After sorting:");

		for (Employee emp : listEmployees) {
			System.out.println(emp);
		}
	}
}
package com.streams;

import java.util.*;

import static java.util.stream.Collectors.*;

public class EmployeeStreamExample {
    //https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
    public static void main(String[] args) {
        List<Employee> employeeList = loadEmployees();
        employeeList.add(null);
        //findMaleAndFemaleEmp(employeeList);
        //printAllNameInOrg(employeeList);
        //averageAgeOfMaleAndFemaleEmp(employeeList);
        //highestPaidEmpInTheOrg(employeeList);
        //namesEmpWhoJoinedAfter2015(employeeList);
        //countTheNumberOfEmpInDept(employeeList);

        //avgSalOfEachDept(employeeList);
        //maxSalOfEachDept(employeeList);
        //minSalOfEachDept(employeeList);
        //groupBySumOfSal(employeeList);
        //groupByDept(employeeList);

        //groupBySummarysing(employeeList);
        //maxSalaryEmp(employeeList);
        //maxValueInList();

        groupByGroup();
    }

    private static void groupByGroup() {
       /* Map<Country, Map<Integer, List<Student>>> studentsByCountryByAge =
                students.stream()
                        .collect(groupingBy(Student::getCountry,
                                groupingBy(Student::getAge)));

        System.out.println(studentsByCountryByAge);*/
    }

    private static void groupByDept(List<Employee> employeeList) {
        Map<String, List<Employee>> empByDeptList =
                Optional.ofNullable(employeeList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(groupingBy(Employee::getDepartment));
        Map<String, Set<Employee>> empByDeptSet =
                Optional.ofNullable(employeeList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .collect(groupingBy(Employee::getDepartment, toSet()));
    }

    private static void maxValueInList() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10, null);
        Integer max = Optional.ofNullable(listOfIntegers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        System.out.println(max);
        Integer min = Optional.ofNullable(listOfIntegers)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
        System.out.println(min);
    }

    private static void maxSalaryEmp(List<Employee> employeeList) {
        Employee minByAge = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(minByAge.getSalary());
        Employee maxByAge = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(maxByAge.getSalary());
    }

    private static void groupBySummarysing(List<Employee> employeeList) {
        Map<String, DoubleSummaryStatistics> summarizingEmp = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment,
                        summarizingDouble(Employee::getSalary)));
        summarizingEmp.forEach((k, v) -> {
            System.out.println(k + "===" + v.getMin() + "====" + v.getMax());
        });
    }

    private static void groupBySumOfSal(List<Employee> employeeList) {
        Map<String, Double> sumOfDept = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment, summingDouble(Employee::getSalary)));
        sumOfDept.forEach((k, v) -> {
            System.out.println(k + "====" + v);
        });
    }

    private static void minSalOfEachDept(List<Employee> employeeList) {
        Map<String, Optional<Employee>> avgSalaryOfDepartments = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment,
                        minBy(Comparator.comparingDouble(Employee::getSalary))));
        avgSalaryOfDepartments.forEach((k, v) -> {
            //System.out.println(k + "====" + v);
        });
        Map<String, Optional<Double>> minAgeByCountry = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment, mapping(Employee::getSalary, minBy(Double::compare))));

        minAgeByCountry.forEach((k, v) -> {
            System.out.println(k + "====" + v.get());
        });
    }

    private static void maxSalOfEachDept(List<Employee> employeeList) {
        Map<String, Optional<Employee>> avgSalaryOfDepartments = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment,
                        maxBy(Comparator.comparingDouble(Employee::getSalary))));
        avgSalaryOfDepartments.forEach((k, v) -> {
            //System.out.println(k + "====" + v);
        });

        Map<String, Optional<Double>> maxAgeByCountry = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment, mapping(Employee::getSalary, maxBy(Double::compare))));

        maxAgeByCountry.forEach((k, v) -> {
            System.out.println(k + "====" + v.get());
        });
    }

    private static void avgSalOfEachDept(List<Employee> employeeList) {
        Map<String, Double> avgSalaryOfDepartments = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
        avgSalaryOfDepartments.forEach((k, v) -> {
            System.out.println(k + "====" + v);
        });
    }

    private static void countTheNumberOfEmpInDept(List<Employee> employeeList) {
        Map<String, Long> employeeCountByDepartment = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getDepartment, counting()));
    }

    private static void namesEmpWhoJoinedAfter2015(List<Employee> employeeList) {
        Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    private static void highestPaidEmpInTheOrg(List<Employee> employeeList) {
        Optional<Employee> highestPaidEmployeeWrapper = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
    }

    private static void averageAgeOfMaleAndFemaleEmp(List<Employee> employeeList) {
        System.out.println("===========averageAgeOfMaleAndFemaleEmp Start===================");
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getGender, averagingInt(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);
        System.out.println("===========averageAgeOfMaleAndFemaleEmp End===================");
    }

    private static void printAllNameInOrg(List<Employee> employeeList) {
        System.out.println("===========printAllNameInOrg Start===================");
        Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
        System.out.println("===========printAllNameInOrg End===================");
    }

    private static void findMaleAndFemaleEmp(List<Employee> employeeList) {
        System.out.println("===========findMaleAndFemaleEmp Start===================");
        Map<String, Long> noOfMaleAndFemaleEmployees = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Employee::getGender, counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
        System.out.println("===========findMaleAndFemaleEmp End===================");
    }

    private static List<Employee> loadEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }
}

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }
}

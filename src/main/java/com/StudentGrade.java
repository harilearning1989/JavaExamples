package com;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGrade {

    public static void main(String[] args) {
        //listToMap();
        studentMarks();
    }
    private static void studentMarks() {
        List<Student> lt = new ArrayList<>();

        lt.add(new Student(88, "Geeks"));
        lt.add(new Student(64, "For"));
        lt.add(new Student(54, "ABC"));
        lt.add(new Student(33, "Geeks"));

        //Map<String, Student> result = lt.stream().collect(Collectors.toMap(book -> book.getName(), book -> book));
        //Map<Student, String> result1 = lt.stream().collect(Collectors.toMap(book -> book,book -> book.getName()));

        Map<Student, String> result2 = lt.stream().collect(Collectors.toMap(book -> book,book ->
                {
                    if(book.getId()>80){
                        return "A";
                    }else if(book.getId() <= 80 && book.getId()>60){
                        return "B";
                    }
                    return "Failed";
                }
        ));

        result2.forEach(
                (x, y) -> System.out.println(x + "=" + y));
    }

    private static void listToMap() {
        System.out.println("SOUT");
        List<Student> lt = new ArrayList<>();

        lt.add(new Student(1, "Geeks"));
        lt.add(new Student(2, "For"));
        lt.add(new Student(3, "Geeks"));
        lt.forEach(f -> System.out.println(f.getId()));

        LinkedHashMap<Integer, String>
                map = lt.stream()
                .collect(
                        Collectors
                                .toMap(
                                        Student::getId,
                                        Student::getName,
                                        (x, y)
                                                -> x + ", " + y,
                                        LinkedHashMap::new));
        map.forEach(
                (x, y) -> System.out.println(x + "=" + y));
    }
}

class Student{

    int id;
    String name;

    public Student(int i, String geeks) {
        this.id=i;
        this.name=geeks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
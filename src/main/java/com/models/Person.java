package com.models;

public class Person {

    private final int id;
    private final String name;
    public Person(final int id,final String name)
    {
        this.id = id;
        this.name = name;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    @Override
    public String toString(){return "Persona{" + "id=" + id + ", name=" + name+'}';}

}

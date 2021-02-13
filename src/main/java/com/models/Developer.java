package com.models;

import java.math.BigDecimal;

public class Developer {

    private String name;
    private BigDecimal num;
    private int age;

    public Developer(String name, BigDecimal b, int i) {
        this.name = name;
        this.num = b;
        this.age = i;
    }
    public Developer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

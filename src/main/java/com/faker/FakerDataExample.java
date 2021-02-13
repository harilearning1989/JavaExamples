package com.faker;

import com.github.javafaker.Faker;

public class FakerDataExample {
	
	Faker faker = new Faker();

	String name = faker.name().fullName();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();

	String streetAddress = faker.address().streetAddress();

}

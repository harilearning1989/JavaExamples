package com.json.read;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader {

	public static void main(String[] args) {
		//convertCarStringJsonTOObject();
		readJsonString();
	}

	private static void readJsonString() {
		/*
		{
			  "id": 123,
			  "name": "Pankaj",
			  "permanent": true,
			  "address": {
			    "street": "Albany Dr",
			    "city": "San Jose",
			    "zipcode": 95129
			  },
			  "phoneNumbers": [
			    123456,
			    987654
			  ],
			  "role": "Manager",
			  "cities": [
			    "Los Angeles",
			    "New York"
			  ],
			  "properties": {
			    "age": "29 years",
			    "salary": "1000 USD"
			  }
			}*/
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = "{\"id\":123,\"name\":\"Pankaj\",\"permanent\":true,\"address\":{\"street\":\"Albany Dr\",\"city\":\"San Jose\",\"zipcode\":95129},\"phoneNumbers\":[123456,987654],\"role\":\"Manager\",\"cities\":[\"Los Angeles\",\"New York\"],\"properties\":{\"age\":\"29 years\",\"salary\":\"1000 USD\"}}";

		try {
			//Address addr = objectMapper.readValue(jsonData, Address.class);
			CompleteAddress addr = objectMapper.readValue(jsonData, CompleteAddress.class);
			System.out.println("Id=="+addr.getId()+"==Name=="+addr.getName()+"==size is==="+addr.getPhoneNumbers().size()+"==size is=="+addr.getCities().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void convertCarStringJsonTOObject() {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		try {
			Car car = objectMapper.readValue(json, Car.class);
			System.out.println("Color==="+car.getColor()+"===type=="+car.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class CompleteAddress{
	private int id;
	private String name;
	private boolean permanent;
	private EmpAddress address;
	private List<Integer> phoneNumbers;
	private String role;
	private List<String> cities;
	private AddressProp properties;

	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public EmpAddress getAddress() {
		return address;
	}
	public void setAddress(EmpAddress address) {
		this.address = address;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
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
	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AddressProp getProperties() {
		return properties;
	}
	public void setProperties(AddressProp properties) {
		this.properties = properties;
	}
}
class EmpAddress{
	private String street;
	private String city;
	private int zipcode;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
class AddressProp{
	private String age;
	private String salary;

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
}
//============================================================================
@JsonIgnoreProperties(ignoreUnknown = true)//it will Ignore the extra properties which has in JSON
class Address{
	private int id;
	private String name;

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
}

class Car{
	private String color;
	private String type;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

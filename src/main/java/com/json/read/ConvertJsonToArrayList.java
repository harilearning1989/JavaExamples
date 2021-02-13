package com.json.read;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonToArrayList {
	public static void main(String[] args) {
		ConvertJsonToArrayList read = new ConvertJsonToArrayList();
		read.readJsonFromString();
	}

	private void readJsonFromString() {
		try{
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("student_data.txt").getFile());
			//InputStream inputStream = new FileInputStream(file);
			//byte[] mapData = Files.readAllBytes(Paths.get("student_data.txt"));
			/*
			URL res = getClass().getClassLoader().getResource("abc.txt");
			File file = Paths.get(res.toURI()).toFile();
			String absolutePath = file.getAbsolutePath();
			*/
			/*
			 * File file = new File("resources/abc.txt");
			   String absolutePath = file.getAbsolutePath();
			 */
			byte[] mapData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
			Student[] studentArr = null;

			ObjectMapper objectMapper = new ObjectMapper();
			studentArr = objectMapper.readValue(mapData, Student[].class);
			List<Student> studentList=Arrays.asList(studentArr);
			System.out.println("Student 1 \n"+studentList.get(0));
			System.out.println("Student 2 \n"+studentList.get(1));
		}
		catch(JsonMappingException ex){
			ex.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Student {
	@JsonProperty(value = "id")
	private int rollNumber;
	@JsonProperty(value = "firstName")
	private String firstName;
	@JsonProperty(value = "lastName")
	private String lastName;
	@JsonProperty(value = "permanent")
	private boolean permanent;
	@JsonProperty(value = "address")
	private StudentAddress address;
	@JsonProperty(value = "phoneNumbers")
	private long[] phoneNumbers;
	@JsonProperty(value = "cities")
	private List<String> cities;
	@JsonProperty(value = "properties")
	private Map<String, String> properties;
	private Date dateOfJoining =new Date();
	@Override
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("==============Student Information================\n");
		sb.append("rollNumber=").append(rollNumber).append("\n");
		sb.append("firstName=").append(firstName).append("\n");
		sb.append("lastName=").append(lastName).append("\n");
		sb.append("permanent=").append(permanent).append("\n");
		sb.append("adress=").append(address).append("\n");
		sb.append("phoneNumbers=").append(Arrays.toString(phoneNumbers)).append("\n");
		sb.append("cities=").append(Arrays.toString(cities.toArray(new String[cities.size()]))).append("\n");
		sb.append("properties=").append(properties).append("\n");
		sb.append("dateOfJoining=").append(dateOfJoining).append("\n");
		return sb.toString();
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public StudentAddress getAddress() {
		return address;
	}
	public void setAddress(StudentAddress address) {
		this.address = address;
	}
	public long[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(long[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
class StudentAddress {
	@JsonProperty(value = "addressLine")
	private String addressLine;
	@JsonProperty(value = "city")
	private String city;
	@JsonProperty(value = "state")
	private String state;
	@JsonProperty(value = "zipCode")
	private int zipCode;
	@Override
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("AddressLine=").append(addressLine).append("\n");
		sb.append("city=").append(city).append("\n");
		sb.append("state=").append(state).append("\n");
		sb.append("zipCode=").append(zipCode).append("\n");
		return sb.toString();
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}

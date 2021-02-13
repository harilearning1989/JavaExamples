package com.practice.serialize.multiple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MultipleSerialization {

	public static void serializeObject(){
		EmployeeModel e = new EmployeeModel();
		e.setName("Hari");
		e.setAddress("ATP");
		e.setSSN(12345);
		e.setNumber(4321);
		DepartmentModel dm=new DepartmentModel();
		dm.setId(12);
		dm.setName("hari");
		e.setDepartmentModel(dm);
		//if subclass not implement serializable interface exception will occures not serializable
	
		try {
			FileOutputStream fileOut = new FileOutputStream("E:/New folder/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in E:/New folder/employee.ser");
		}catch(IOException i) {
			i.printStackTrace();
		}
	}

	public static void deSerializeObject(){
		EmployeeModel e = null;
		try {
			FileInputStream fileIn = new FileInputStream("E:/New folder/employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (EmployeeModel) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("EmployeeModel class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized EmployeeModel...");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("Number: " + e.number);
		System.out.println("department id: " + e.getDepartmentModel().getId());
		System.out.println("department name: " + e.getDepartmentModel().getName());

	}
	
	public static void main(String[] args) {
		serializeObject();
		deSerializeObject();
	}
}
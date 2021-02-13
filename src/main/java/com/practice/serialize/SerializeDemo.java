package com.practice.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeDemo {

	public static void serializeObject(){
		Employee e = new Employee();
		e.setName("Hari");
		e.setAddress("ATP");
		e.setSSN(12345);
		e.setNumber(4321);
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
		Employee e = null;
		try {
			FileInputStream fileIn = new FileInputStream("E:/New folder/employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("Number: " + e.number);

	}

	public static void serializeArrayList(){
		ArrayList<String> al=new ArrayList<String>();
		al.add("Hello");
		al.add("Hari");
		al.add("Reddy");

		try{
			FileOutputStream fos= new FileOutputStream("myfile");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(al);
			oos.close();
			fos.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public static void deSerializeArrayList(){
		ArrayList<String> arraylist= new ArrayList<String>();
		try
		{
			FileInputStream fis = new FileInputStream("myfile");
			ObjectInputStream ois = new ObjectInputStream(fis);
			arraylist = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		for(String tmp: arraylist){
			System.out.println(tmp);
		}
	}

	public static void main(String [] args) {
		//SerializeDemo.serializeObject();
		//SerializeDemo.deSerializeObject();
		serializeArrayList();
		deSerializeArrayList();
	}
}

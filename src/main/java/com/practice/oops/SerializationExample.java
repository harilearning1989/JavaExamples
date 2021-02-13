package com.practice.oops;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Serialization is usually used When the need arises to send your data over network or stored in files. 
	By data I mean objects and not text.Now the problem is your Network infrastructure and your Hard disk are hardware 
	components that understand bits and bytes but not JAVA objects.
	Serialization is the translation of your Java object's values/states to bytes to send it over network or save it.
	This is analogous to how your voice is transmitted over PSTN telephone lines.
	 */

	public void serializeExample(){
		
		EmployeeSerialize employeeSerialize = new EmployeeSerialize();  
		employeeSerialize.setEmployeeId(101);  
		employeeSerialize.setEmployeeName("Hari");  
		employeeSerialize.setDepartment("MCA");  
		try{  
			FileOutputStream fileOut = new FileOutputStream("D:/employee.ser");  
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);  
			outStream.writeObject(employeeSerialize);  
			outStream.close();  
			fileOut.close();  
			System.out.println("======Success=========");
		}catch(IOException i){  
			i.printStackTrace();  
		}  
	}
	public void deSerializeExample(){
		
		EmployeeSerialize e = null;
		try {
			FileInputStream fileIn = new FileInputStream("D:/employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (EmployeeSerialize) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("EmployeeSerialize class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized Employee...");
		System.out.println("Employee Id : " + e.getEmployeeId());
		System.out.println("it is a transient variable we cannot serialize so only it is null=====" + e.getEmployeeName());
		System.out.println("Department==: " + e.getDepartment());

	}
	public static void main(String[] args) {
		SerializationExample serializationExample=new SerializationExample();
		serializationExample.serializeExample();
		serializationExample.deSerializeExample();
	}
}

package com.json.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteObjectToJson {

	public static void main(String[] args) {
		WriteObjectToJson write = new WriteObjectToJson();
		write.writeJsonObject();
		try {
			write.writeJsonSimpleDemo("example.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeJsonObject() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ID", "1");
		jsonObject.put("First_Name", "Shikhar");
		jsonObject.put("Last_Name", "Dhawan");
		jsonObject.put("Date_Of_Birth", "1981-12-05");
		jsonObject.put("Place_Of_Birth", "Delhi");
		jsonObject.put("Country", "India");
		try {
			FileWriter file = new FileWriter("E:/output.json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON file created: "+jsonObject);
	}
	public void writeJsonSimpleDemo(String filename) throws Exception {
		JSONObject sampleObject = new JSONObject();
		sampleObject.put("name", "Stackabuser");
		sampleObject.put("age", 35);

		JSONArray messages = new JSONArray();
		messages.add("Hey!");
		messages.add("What's up?!");

		sampleObject.put("messages", messages);
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		
		Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
	}

}

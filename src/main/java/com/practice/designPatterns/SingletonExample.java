package com.practice.designPatterns;

public class SingletonExample {
	private static SingletonExample instance=null;
	private SingletonExample(){

	}
	public static SingletonExample getInstance(){
		if(instance == null){
			instance = new SingletonExample();
			return instance;
		}
		return instance;
	}

	public static SingletonExample getInstanceDoubleCheck() { 
		if (instance == null) { // Single Checked 
			synchronized (SingletonExample.class) { 
				if (instance == null) { // Double checked 
					instance = new SingletonExample(); 
				} 
			} 
		} 
		return instance; 
	}
}
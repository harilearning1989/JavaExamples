package com.practice.designPatterns;

public class FactoryMain {

	public static FactoryInterface getPlan(String instaneType){  
		if(instaneType == null){  
			return null;  
		}  
		if(instaneType.equalsIgnoreCase("class1")) {  
			return new FactoryClass1();  
		}else if(instaneType.equalsIgnoreCase("class2")){  
			return new FactoryClass2();  
		}else if(instaneType.equalsIgnoreCase("class3")) {  
			return new FactoryClass3();  
		}  
		return null;  
	}  
	public static void main(String[] args) {
		FactoryInterface factoryInterface = FactoryMain.getPlan("class2");
		factoryInterface.getRate();
	}
}

package com.practice.equals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EqualsAndHashcode {
	
	public static void equalTest(){
		CountryModel india1=new CountryModel();  
		india1.setName("India");  
		CountryModel india2=new CountryModel();  
		india2.setName("India");  
		
		System.out.println("Is india1 is equal to india2:" +india1.equals(india2)); 
	}

	public static void hashMapTest(){
		
		HashMap<CountryModel,String> countryCapitalMap=new HashMap<CountryModel,String>();   
		CountryModel india1=new CountryModel();  
		india1.setName("India");  
		CountryModel india2=new CountryModel();  
		india2.setName("India");  

		countryCapitalMap.put(india1, "Delhi");  
		countryCapitalMap.put(india2, "Delhi");  

		Iterator<CountryModel> countryCapitalIter=countryCapitalMap.keySet().iterator();  
		while(countryCapitalIter.hasNext())  
		{  
			CountryModel countryObj=countryCapitalIter.next();  
			String capital=countryCapitalMap.get(countryObj);  
			System.out.println("Capital of "+ countryObj.getName()+"----"+capital);  

		}  
	}
	public static void checkObjects(){
		
		CountryModel india1=new CountryModel();  
		india1.setName("India");  
		CountryModel india2=new CountryModel();  
		india2.setName("India");  
		
		Map<CountryModel, String> map=new HashMap<CountryModel,String>();
		map.put(india1, "Hari");
		map.put(india2, "1");
		
		System.out.println(map.size());
		
		for(Entry<CountryModel, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+"==="+entry.getValue());
		}
		
	}

	public static void main(String[] args) {
		//equalTest();
		//hashMapTest();
		checkObjects();
	}
}

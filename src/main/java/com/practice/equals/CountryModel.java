package com.practice.equals;

public class CountryModel {

	String name;  
	long population;  

	public String getName() {  
		return name;  
	}  
	public void setName(String name) {  
		this.name = name;  
	}  
	public long getPopulation() {  
		return population;  
	}  
	public void setPopulation(long population) {  
		this.population = population;  
	}  

	public boolean equals(Object obj) { 
		if(obj != null && obj instanceof CountryModel){
			String name=((CountryModel)obj).getName();
			if(name !=null && name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return this.name.hashCode();
	}
	
	//or
	
	/*@Override  
	public boolean equals(Object obj) {  
		if (this == obj)  
			return true;  
		if (obj == null)  
			return false;  
		if (getClass() != obj.getClass())  
			return false;  
		CountryModel other = (CountryModel) obj;  
		if (name == null) {  
			if (other.name != null)  
				return false;  
		} else if (!name.equals(other.name))  
			return false;  
		return true;  
	}  
	@Override  
    public int hashCode() {  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + ((name == null) ? 0 : name.hashCode());  
        return result;  
    }  */

}
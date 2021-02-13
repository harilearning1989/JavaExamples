package com.practice.collections;

public class SetWithModelClass {

	private int id;
	private String name;
	public SetWithModelClass(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof SetWithModelClass)) {
			return false;
		}
		SetWithModelClass s = (SetWithModelClass) o;
		return s.name.equals(name) && s.id == id ;
	}
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + id;
		return result;
	}
}

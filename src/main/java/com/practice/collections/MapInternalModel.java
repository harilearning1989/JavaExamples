package com.practice.collections;

public class MapInternalModel {

	private Integer i;
	public MapInternalModel(Integer i) {
		this.i = i;
	}
	public Integer getI() {
		return i;
	}
	@Override
	public int hashCode() {
		System.out.println("hari reddy hashcode");
		System.out.println("MyInt HashCode: " + i.hashCode());
		return i.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.printf("MyInt equals: [%s, %s]%n", i, obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapInternalModel other = (MapInternalModel) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return i.toString();
	}
}
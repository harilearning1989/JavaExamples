package com.practice.collections;

import java.util.HashMap;
import java.util.Map;

public class MapInternalImplementation {

	/*HashMap works on the principal of hashing.
	Map.Entry interface - This interface gives a map entry (key-value pair). 
	HashMap in Java stores both key and value object, in bucket, as Entry object which implements this nested interface Map.Entry.

	hashCode() -HashMap provides put(key, value) for storing and get(key) method for retrieving Values from HashMap. 
	When put() method is used to store (Key, Value) pair, HashMap implementation calls hashcode on Key object to 
	calculate a hash that is used to find a bucket where Entry object will be stored. 
	When get() method is used to retrieve value, again key object is used to calculate a 
	hash which is used then to find a bucket where that particular key is stored.

	equals() - equals() method is used to compare objects for equality. 
	In case of HashMap key object is used for comparison, also using equals() 
	method Map knows how to handle hashing collision (hashing collision means more 
	than one key having the same hash value, thus assigned to the same bucket. 
	In that case objects are stored in a linked list.
	Where hashCode method helps in finding the bucket where that key is stored, 
	equals method helps in finding the right key as there may be more than one key-value pair stored in a single bucket.
	 */

	public static void show(){
		Map<MapInternalModel,String> map = new HashMap<MapInternalModel,String>();
		map.put(new MapInternalModel(1),"abc");
		map.put(new MapInternalModel(2), "xyz");
		map.put(new MapInternalModel(3), "gnz");
		map.put(new MapInternalModel(4), "lmn");
		map.put(new MapInternalModel(5), "lmp");
		map.put(new MapInternalModel(5), "mnp");
	}

	public static void main(String[] args) {
		show();
	}
}
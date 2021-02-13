package com.practice.collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class NavigableMapDemo {

	public static void main(String[] args) {
		navigableMapMethods();
	}

	private static void navigableMapMethods() {
		NavigableMap<String, String> original = new TreeMap<>();
		original.put("1", "1");
		original.put("2", "2");
		original.put("3", "3");
		original.put("4", "4");
		original.put("5", "5");

		SortedMap<String, String> submap1  = original.subMap("2", "4");
		NavigableMap<String, String> submap2 = original.subMap("2", true, "4", true);
		SortedMap<String, String> tailMap = original.tailMap("c");
		Object ceilingKey = original.ceilingKey("2");
		Object floorKey = original.floorKey("2");
		Object higherKey = original.higherKey("2");
		Object lowerKey = original.lowerKey("2");
		
		Map.Entry ceilingEntry = original.ceilingEntry("c");
		Map.Entry floorEntry = original.floorEntry("c");
		Map.Entry higherEntry = original.higherEntry("c");
		Map.Entry lowerEntry = original.lowerEntry("b");
		Map.Entry first = original.pollFirstEntry();
		Map.Entry last = original.pollLastEntry();
		
		NavigableMap descending = original.descendingMap();
		NavigableSet reverse = original.descendingKeySet();
	}

}

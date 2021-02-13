package com.practice.collections;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class ListPracticed {

	public static void addAndRemItems(){
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add(1);
		System.out.println(list);
		list.remove("c");//possible it deletes the c
		list.remove("1");//possible item is not there in the list nothing will happen
		System.out.println(list);
	}
	public static void getRepetedItems(){
		List list=new ArrayList();

		list.add(1);list.add(12);list.add(14);list.add(13);list.add(2);list.add(71);list.add(1);
		list.add(21);list.add(1);list.add(2);list.add(24);list.add(33);list.add(32);list.add(41);
		list.add(31);list.add(2);list.add(4);list.add(3);list.add(2);list.add(61);list.add(1);
		list.add(11);list.add(51);list.add(21);list.add(4);list.add(3);list.add(2);list.add(1);

		Set setDup=new HashSet();
		for(int i=0;i<list.size();i++){
			int firstItem=(Integer)list.get(i);
			for(int j=i+1;j<list.size();j++){
				int secondItem=(Integer)list.get(j);
				if(firstItem == secondItem){
					setDup.add(firstItem);
					break;
				}
			}
		}
		System.out.println(setDup);
	}
	public static void getNonRepetedItems(){
		int arr[]={1,2,3,4,5,6,7,8,9,1,2,3,4,11,12,12,14};
		int flag=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(i != j){
					if(arr[i] != arr[j]){
						flag = 1;
					}else{
						flag = 0;
						break;
					}
				}
			}
			if(flag == 1){
				System.out.println(arr[i]+"");
			}
		}
	}

	public static void remDuplicatesFromList(){
		List<String> list=new ArrayList<String>();
		list.add("h");list.add("a");list.add("b");list.add("a");
		list.add("c");list.add("b");
		Set<String> set=new HashSet<String>(list);
		list.clear();
		list.addAll(set);

		System.out.println("list items with unique "+list);
	}
	public static void retainAllExamples(){
		ArrayList<String> color_list = new ArrayList<String>();  

		color_list.add("White");  
		color_list.add("Black");  
		color_list.add("Red");  

		ArrayList<String> sample = new ArrayList<String>();  

		sample.add("Green");   
		sample.add("Red");   
		sample.add("White");  

		color_list.retainAll(sample);  

		System.out.println("After applying the method, First List :"+ color_list);  
		System.out.println("After applying the method, Second List :"+ sample);  

	}

	public void stringExample(){

		// ArrayList Example

		ArrayList<String> arrlistobj = new ArrayList<String>();
		arrlistobj.add("Alive is awesome");
		arrlistobj.add("Love yourself");
		Iterator it = arrlistobj.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
		// Array Example

		String[] arrayobj = new String[3];
		arrayobj[0]= "Love yourself";
		arrayobj[1]= "Alive is awesome";
		arrayobj[2]= "Be in Present";
		System.out.print("Array object output :");
		for(int i=0;i<arrayobj.length;i++){
			System.out.print(arrayobj[i] + " ");
		}
	}

	public static void sumOfArray(){
		int[] a={1,2,4,5,6};
		int sum=0;

		for(int i=0;i<a.length;i++){
			sum=sum+a[i];
			if(sum>10){
				System.out.println("great");
				//break;
			}
		}
		System.out.println(sum);
	}

	private static void findingFrequency() {

		List<Integer> listNumber=new ArrayList<Integer>();
		listNumber.add(1);
		listNumber.add(2);
		listNumber.add(3);
		listNumber.add(3);
		listNumber.add(2);
		listNumber.add(1);
		listNumber.add(1);

		Map<Integer, Integer> map=new HashMap<Integer,Integer>();

		for(Integer i:listNumber){
			map.put(i, Collections.frequency(listNumber, i));
		}
		System.out.println(map);
		/*List listNumber=new ArrayList();
		listNumber.add(1);
		listNumber.add(2);
		listNumber.add(3);
		listNumber.add(3);
		listNumber.add(2);
		listNumber.add(1);
		listNumber.add(1);

		Set<Integer> uniqueSetNum = new HashSet<Integer>(listNumber);
		for (Integer temp : uniqueSetNum) {
			System.out.println(temp + ": " + Collections.frequency(listNumber, temp));
		}

		System.out.println("=======================================");

		List listString=new ArrayList();
		listString.add("H");
		listString.add("S");
		listString.add("H");
		listString.add("S");
		listString.add("A");
		listString.add("B");
		listString.add("B");

		Set<String> uniqueSetStr = new HashSet<String>(listString);
		for (String temp : uniqueSetStr) {
			System.out.println(temp + ": " + Collections.frequency(listString, temp));
		}*/
	}
	public static  void listDuplicatesPracticed(){

		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Anil");
		hm.put(2, "Deven");
		hm.put(2, "Deven");
		hm.put(3, "sanjay");
		hm.put(4, "sanjay");
		hm.put(5, "Raj");
		hm.put(6, "sanjay");

		HashSet<String> values = new HashSet<String>(hm.values());

		for (String str : values){
			System.out.println("removing duplicate values from map ===========  "+str);
		}

		HashSet<Integer> keys = new HashSet<Integer>(hm.keySet());

		for (Integer inte : keys){
			System.out.println("removing duplicate keys from map ===========  "+inte);
		}

		List al2=new ArrayList();
		al2.add(31);
		al2.add(2);
		al2.add(54);
		al2.add(3);

		al2.remove(2);//bydefault it will remove index based it will remove 54
		al2.remove(new Integer(1)); //it will remove 1 if it is there otherwise it will not do anything

		System.out.println("removeing   integer==="+al2);

		List al3=new ArrayList();
		al3.add("hari");
		al3.add("reddy");
		al3.add("krishna");
		al3.add("kumar");
		al3.add("1");
		al3.add("1");
		al3.add("2");
		al3.remove(new String("1"));//removes from first occurrence of the item
		System.out.println("removeing   integer==="+al3);

	}

	public static void linkedList(){
		List l=new LinkedList();
		l.add("z");
		l.add("d");
		l.add("aa");
		l.add("b");
		l.add("d");
		l.add("c");
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
	}
	public static void exampleArrayList(){

		List<Integer> alInteger=new ArrayList<Integer>();
		//alInteger.add("hari");//compile time error
		//alInteger.add("1");//compile time error
		alInteger.add(1);
		System.out.println("al2 data is "+alInteger);

		/*Duplicate elements : Both array and arraylist can contain duplicate elements.

		3. Null Values : Both can store null values and uses index to refer to their elements. 

		ArrayList cannot contains primitive data types (like int , float , double) 
		it can only contains Object like Integer,String,Float,Double*/

		List  arraylistobject = new ArrayList();
		arraylistobject.add(23);

		/* JVM through Autoboxing(converting primitives to equivalent objects internally) 
			ensures that only objects are added to the arraylist object. 
			thus , above step internally works like this : */

		arraylistobject.add( new Integer(23));  
		arraylistobject.add( new String("abcd"));  
		// Converted int primitive to Integer object and added to arraylistobject  
		arraylistobject.add(12); 

		System.out.println("arraylistobject size is --------==========----------  "+arraylistobject.size());

		String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal"};
		System.out.println(citynames.length-1);

		/*Array to ArrayList conversion*/
		List<String> citylist= new ArrayList<String>(Arrays.asList(citynames));
		System.out.println("------converting array to arraylist  the list  is  ------------"+citylist);
		citynames=null;
		System.out.println("after making null ========================"+citynames);
		System.out.println("List data is pending  list to array convertion  ========================  "+citylist);
		//=============================================================================================================

		//=========================================================================================================
		List<String> myList=new ArrayList<String>();

		/* When we create an ArrayList in this way, default constructor is invoked and will internally create an 
		  array of Object with default size, which is 10.*/

		List<String> myList1=new ArrayList<String>(5);

		/* When we create an ArrayList in this way, constructor with an integer  argument is invoked and will internally
		  create an array of Object with the size, specified in the constructor argument, which happens to be 5 in this 
		  case.Now, As we all know that unlike normal arrays, the size of the ArrayList grows dynamically. 
		  But how its size grows internally?

		  Inside .add() method there is this check. So,before adding element into the array it will check what is the 
		  current size of filled elements and what is the maximum size of the array. If size of filled elements is 
		  greater than maximum size of the array then size of the array must be increased. But we know that the size 
		  of the array cannot be  increased dynamically.

		  So what happens internally is a new Array is created with size 1.5*currentSize and the data from old Array is 
		  copied into this new Array. */
		//==============================================================================================================

		/*  There are two overloaded add() methods in ArrayList class:

	        add(Object)  : adds object to the end of the list.
			add(int index , Object )  : inserts the specified object at the specified position in the list. */
		//========================================================================================================
		/* public boolean add(E e)
		  {
		       ensureCapacity(size+1);
		       elementData[size++] = e;         
		       return true;
		  } /*/
	}

	public static void maxAndMin(){

		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(1,3);
		map.put(2,4);
		map.put(3,6);
		map.put(4,1);
		map.put(5,7);
		map.put(6,2);
		List list=new ArrayList(map.values());
		List keys=new ArrayList(map.keySet());
		System.out.println(keys);

		//================================================================================
		//finding maximum value 2 ways
		System.out.println("Collections.max(list)========="+Collections.max(list));
		//or
		int max=0;  //Integer.MIN_VALUE;
		for(int i=0; i<list.size(); i++){
			int a=(Integer) list.get(i);
			if(a > max){
				max = (Integer) list.get(i);
			}
		}
		System.out.println("map.get(1)======="+map.get(1));
		for(Entry<Integer, Integer> obj : map.entrySet()){
			if(obj.getValue().equals(Collections.max(list))){
				System.out.println("obj.getKey()=========="+obj.getKey());
			}
		}

		System.out.println("the max value is "+max);

		//================================================================================
		//finding minimum value 2 ways
		System.out.println("Collections.min(list)========="+Collections.min(list));
		//or
		int min=Integer.MAX_VALUE;
		for(int i=0; i<list.size(); i++){
			int b=(Integer) list.get(i);
			if(b < min){
				min = (Integer) list.get(i);
			}
		}
		System.out.println("the min value is "+min);
	}

	public static void seqFind(){

		boolean val=false;
		int a[]={1,2,4,8,16,32};
		for(int i=1;i<a.length;i++){
			int b=a[i];
			int c=a[i-1];
			int d=b/c;
			//int d=b-c;
			//if(d==c){
			if(d==2){
				val=true;
			}else{
				val=false;
				break;
			}
		}
		if(val==true){
			System.out.println("seqFind===the sequence is true");
		}else{
			System.out.println("seqFind===the sequence is false");
		}

		boolean valList=false;
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(32);
		list.add(4);
		list.add(8);
		list.add(16);
		list.add(33);

		for(int i=1;i<list.size();i++){
			int b= list.get(i);
			int d= list.get(i-1);
			int c=b-d;
			if(c==d){
				valList=true;
			}else{
				valList=false;
				System.out.println(list.get(i));
				break;
			}
		}
		if(valList==true){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	public static void remDuplicates(){

		List al=new ArrayList();

		al.add("one");
		al.add("two");
		al.add("one");
		al.add("three");
		al.add("one");
		al.add("three");
		al.add("seven");
		al.add("six");
		al.add("four");
		al.add("three");
		al.add("four");

		//for unique,non repeated 

		ArrayList al1=new ArrayList();

		//removing the duplicates 

		/*for (int i = 0; i < al.size(); i++) {
			String alFirst=al.get(i).toString();
			for (int j = i+1; j <al.size(); j++) {
				String alSecond=al.get(j).toString();
				if (alFirst.equals(alSecond)) {
					al.remove(j);
				}
			}
		}*/
		boolean repStatus=false;
		for (int i = 0; i < al.size(); i++) {
			String alFirst=al.get(i).toString();
			for (int j = i+1; j <al.size(); j++) {
				String alSecond=al.get(j).toString();
				if (alFirst.equals(alSecond)) {
					repStatus=true;
					break;
				}else{
					//repStatus=false;
				}
				if(repStatus==false){
					al1.add(alFirst);
				}
			}
		}
		System.out.println("the al list data is  "+al1); //two,seven,six,fiv
		System.out.println("============removing integer duplicates using hashset==============");
	}

	public static void iteratorExample(){
		List alIterator=new ArrayList();
		alIterator.add(2.3);
		alIterator.add(3.4);
		alIterator.add(4.4);

		System.out.println(alIterator.contains(2.31));//shows false

		alIterator.set(1, 1.1);
		alIterator.add(1, 0.4);

		System.out.println("finding the item index in the list  "+alIterator.indexOf(2.3));//it will show 0

		Iterator iterator = alIterator.iterator();
		while (iterator.hasNext()) {
			System.out.println("=========iterator data in arraylist========="+iterator.next());
		}
	}
	public static void remWays(){

		List<String> alRemove=new ArrayList<String>();
		alRemove.add("one");
		alRemove.add("two");
		alRemove.add(null);
		alRemove.add("one");
		alRemove.add("three");
		alRemove.add(null);
		System.out.println("remove one   "+alRemove.remove("one"));//it will show true,if duplicates is there first 
		//occurrence of the item will remove
		System.out.println("remove 10  "+alRemove.remove("10"));//it will show false
		//System.out.println("remove 10  "+alRemove.remove(10));//indexOutOfBouns
		System.out.println("list data1111 is   "+alRemove);
		System.out.println("remove index 3   "+alRemove.remove(3));
		System.out.println("list data22222222 is   "+alRemove);
		alRemove.remove(null);//first occurrence will be removed
		System.out.println("after remove null is   "+alRemove);

		List al2=new ArrayList();
		al2.add(31);
		al2.add(2);
		al2.add(54);
		al2.add(30);

		System.out.println(" 1 i snot ther in list so it will print index "+al2.get(new Integer(1)));

		//System.out.println("index out of bound "+al2.get(new Integer(30)));

		al2.remove(2);//bydefault it will remove index based it will remove 54
		al2.remove(new Integer(1)); //it will remove 1 if it is there otherwise it will not do anything

		System.out.println("================================================");

		List al3=new ArrayList();
		al3.add("hari");
		al3.add("reddy");
		al3.add("krishna");
		al3.add("kumar");
		al3.add("1");
		al3.add("1");
		al3.add("2");
		al3.remove(new String("1"));//removes from first occurrence of the item
		System.out.println("removeing   integer==="+al3);

	}

	public static void listToArray(){ 
		ArrayList<String> alCopy = new ArrayList<String>();

		//Adding elements to the ArrayList
		alCopy.add("Apple");
		alCopy.add("Orange");
		alCopy.add("Mango");
		alCopy.add("Grapes");

		Object[] ob = alCopy.toArray();

		for (Object value : ob) {
			System.out.println("alCopy to array = " + value);
		}

		ArrayList<String> al2Copy = (ArrayList<String>)alCopy.clone();
		System.out.println(al2Copy);

	}

	public static void listMod(){

		List modList=new ArrayList();
		modList.add(2);
		modList.add(4);
		modList.add(6);

		System.out.println("=====================   "+modList.get(modList.size()-1));

		List modList1=new ArrayList();

		for(int i=0;i<modList.size();i++){
			int modInt=(Integer)modList.get(i);
			modInt=modInt*2;
			modList1.add(modInt);
		}
		System.out.println("modifying the arraylist    ++++++++++++ "+modList1);

		Iterator itr = modList1.iterator();

		while (itr.hasNext()) {
			int i=(Integer)itr.next();
			System.out.println(i/2);

			// strElement = (String) itr.next();
			//if (strElement.equals("2")) {
			// itr.remove();
			// break;
			//}
		}
	}

	public static void modelDataExample() {

		ArrayListModel obj=new ArrayListModel();
		List<ArrayListModel> obj1=new ArrayList<ArrayListModel>();

		obj.setAddress("AP");
		obj.setAge(23);
		obj.setCity("bbsr");
		obj.setName("sitansu");
		obj.setRollno(209);

		obj1.add(obj);

		obj=new ArrayListModel();
		obj.setAddress("UP");
		obj.setAge(21);
		obj.setCity("dfsre");
		obj.setName("ewrtfs");
		obj.setRollno(5345);

		obj1.add(obj);

		obj=new ArrayListModel();

		obj.setAddress("TN");
		obj.setAge(2312);
		obj.setCity("rrewfwf");
		obj.setName("xxvzv");
		obj.setRollno(434);

		obj1.add(obj);

		for(int i=0;i<obj1.size();i++){
			int a=(Integer) obj1.get(i).getAge();
			a=a/2;
			//obj1.add(a);
			//obj1.set(i,a);
		}

		for(ArrayListModel data:obj1){
			//  System.out.println(data.getAddress()+ "   "+data.getAge()+"   "+data.getCity()+"   "+data.getRollno()+"   "+data.getName());
		}
		List l2=new ArrayList();
		l2.add(2);
		l2.add(5);
		l2.add(7);
		l2.add(3);
		l2.add(8);

		for(int i=0;i<l2.size();i++){
			int a=(Integer) l2.get(i);
			a=a/2;
			l2.set(i,a);
		}
		System.out.println(l2);
	}	
	public void objectCreationWays(){
		Collection c=new ArrayList();
		List list=new ArrayList();
		AbstractCollection ac=new ArrayList();
		AbstractList al=new ArrayList();
		ArrayList al1=new ArrayList();
	}
	public static void arrayIndexBounds(){
		List list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		try{
			System.out.println(list.get(4));
		}catch(Exception e){
			System.out.println(e);
		}

		System.out.println("arrayIndexBounds===========");
	}

	public static void fibonaciTest(){
		int arr[]={1,1,2,3,5,8,13,21,34};
		boolean flag=true;
		for(int i=2;i<arr.length;i++){
			int sum=arr[i-2]+arr[i-1];
			if(sum != arr[i]){
				flag=false;
				break;
			}
		}
		if(!flag){
			System.out.println("not following fibonacci");
		}else{
			System.out.println("the values following fibonacci");
		}
	}
	//pending
	public static void convertToString1(String[] args) {

		List<String> duplicateList = (List<String>) Arrays.asList("Android" , "Android", "iOS", "Windows mobile");
		System.out.println("size of Arraylist with duplicates: " + duplicateList.size()); //should print 4 because of duplicates Android

		System.out.println(duplicateList);

		//Converting ArrayList to HashSet to remove duplicates
		HashSet<String> listToSet = new HashSet<String>(duplicateList);

		//Creating Arraylist without duplicate values
		List<String> listWithoutDuplicates = new ArrayList<String>(listToSet);
		System.out.println("size of ArrayList without duplicates: " + listToSet.size()); //should print 3 becaues of duplicates Android removed

		System.out.println(listWithoutDuplicates);
		//===================================================================
		System.out.println("====================================================");
	}

	public static void main(String[] args) {
		/*exampleArrayList();
		seqFind();
		maxAndMin();
		remDuplicates();
		iteratorExample();
		remWays();
		listToArray(); 
		listMod(); 
		listDuplicatesPracticed();
		findingFrequency();
		sumOfArray();
		arrayIndexBounds();

		fibonaciTest();*/
		//getNonRepetedItems();
		//getRepetedItems();
		addAndRemItems();
	}	
}
package com.practice.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPracticed {
	static StringPracticed myObj=new StringPracticed();

	public static void equalsIgnore(){

		String s1 = "Hello"; 
		String s2 = "Hello"; 
		String s3 = "Good-bye"; 
		String s4 = "HELLO"; 
		String s5 = new String("HELLO");
		System.out.println("======"+s4.equals(s5));
		
		if(s1.equalsIgnoreCase(s4)){
			System.out.println("case-insensitive===true===="+s1.equalsIgnoreCase(s4));
		}else{
			System.out.println("false===="+s1.equalsIgnoreCase(s4));
		}
		
		if(s1.equals(s4)){
			System.out.println("case-sensitive===true===="+s1.equals(s4));
		}else{
			System.out.println("case-sensitive===false===="+s1.equals(s4));
		}
	}

	public static void interviewExample(){
		String str="abc";
		StringBuffer sb= new StringBuffer(str);
		System.out.println(str.equals(sb.toString()));

		String strNull="";
		System.out.println(strNull);

		String str1 = null; // null can be assigned to String
		Integer itr = null; // you can assign null to Integer also
		Double dbl = null;  // null can also be assigned to Double

		String myStr = (String) null; // null can be type cast to String
		Integer myItr = (Integer) null; // it can also be type casted to Integer
		Double myDbl = (Double) null; // yes it's possible, no error
		double d = dbl;
		System.out.println("" + d);
	}
	public static void removingDuplicates(){
		/*String str="abab";

		Set s=new HashSet();
		for(int i=0;i<str.length();i++){
			s.add(str.charAt(i));
		}
		System.out.println(str);
		System.out.println(s);*/

		String str1="abcd";
		for(int i=0;i<=str1.length()-1;i++){
			//System.out.println(str1.charAt(i));
		}
		for(int j=str1.length()-1;j>=0;j--){
			System.out.println(str1.charAt(j));
		}
	}

	public static void stringReverse(){
		/*
	    The easiest way to reverse a given string is to use reverse()
	    method of java StringBuffer class.
	    reverse() method returns the StringBuffer object so we need to
	    cast it back to String using toString() method of StringBuffer
		 */
		String strOriginal = "Hello";
		System.out.println("Original String : " + strOriginal);
		strOriginal = new StringBuffer(strOriginal).reverse().toString();
		System.out.println("Reversed String : " + strOriginal);

		String splitTheString="http/local/D/hari";
		int last=splitTheString.lastIndexOf("/");
		//String path=splitTheString.substring(last+1,splitTheString.length()-1);
		String path=splitTheString.substring(last+1,splitTheString.length());
		System.out.println("splitTheString=========="+splitTheString);
		System.out.println("last=========="+last);
		System.out.println("path=========="+path);
	}
	public static void compareToExample(){
		Integer i1=new Integer("21");
		Integer i2=new Integer("2");
		int retVal=i1.compareTo(i2);
		System.out.println("retVal  value======"+retVal);
		if(retVal==0){
			System.out.println("values are equal");
		}else if(retVal>0){
			System.out.println("i1 is greater than i2");
		}else if(retVal<0){
			System.out.println("i1 is less than i2");
		}
	}
	public static void compareToExampleString(){
		String str1="hari";
		String str2="harireddy";
		//while comparing the string if it is equal returns the zero
		//if str1 length is greater to str1 it prints the extra characters in positive value
		//if str2 length is greater to str1 it prints the extra characters in negative value
		int retVal=str1.compareTo(str2);
		if(retVal==0){
			System.out.println("Strings are equal");	
		}else{
			System.out.println("Strings are not equal");
		}	
		System.out.println(retVal);
	}
	public static void findFrequency(){
		String str="a b m n m n b a d";
		List list=Arrays.asList(str.split(" "));
		System.out.println("counting the letters in string-======="+list.size()+"==it will count the total length===="+str.length());

		/*Iterator iterate=list.iterator();
		while(iterate.hasNext()){
			System.out.println(iterate.next());
		}*/
		System.out.println("==================");
		/*for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}*/

		//removing duplicates
		Set set=new HashSet(list);

		/*Iterator iterateSet=set.iterator();
		while(iterateSet.hasNext()){
			System.out.println(iterateSet.next());
		}*/

		for(Object obj:set){
			System.out.println(obj+"===="+Collections.frequency(list, obj));
		}
	}

	public static void stringCompare(){
		String s1="hari";
		String s2="hari";
		String s3="hari";
		String s4=s3;

		if(s4==s2){
			//System.out.println("if  0000000000");
		}
		String s5=new String(s3);
		if(s5==s2){
			System.out.println("if  0000000000");
		}else{
			System.out.println("else");
		}
		//String s4=new String(s3);
		/*System.out.println(s3.substring(1));
		System.out.println(s3.substring(1, 3));*/
		//String s4=new String("hari");
		//String s5=new String(s3);
		/*System.out.println(s5.equals(s4));
		System.out.println((s5==s4));*/
		/*if(s1 == s2){
			System.out.println("if  0000000000");
		}else{
			System.out.println("else 11111");
		}*/

		/*if(s5 == s6){
			System.out.println("s5 == s6  if  0000000000");
			System.out.println(s6);
		}else{
			System.out.println("s3 == s5  else 11111");
		}*/

	}

	/*equals() method defined in "object" class.
	By default equals methods behaves like "==" operator when comparing objects.
	By default equals() method compares references of objects.
	But All wrapper classes and String class overriding this equals method and comparing data .
	Means in String class and in All wrapper classes this equals() methods is overridden so that to compare data of those class objects. 
	 */
	/* == operator used to compare objects references.
	 * used to compare data of primitive data types
	 * if  we are comparing two objects using "==" operator if reference of both are same 
	 * then it will returns true otherwise returns false.
	 *  obj1==obj2;
	 *  If we are comparing primitive data type variables then it compares data of those two variables
	 *   Ex: int a=12; int b=12; if(a==b) returns true*/

	public static void countTokens(){
		String str="hari reddy hari reddy123@#$";
		System.out.println(str.replace("[1-9],@#$", "1"));
		/*System.out.println(str.replace("hari", "1"));
		System.out.println(str.length());
		StringTokenizer stk=new StringTokenizer(str);
		System.out.println(stk.countTokens());*/
		System.out.println(str.indexOf("reddy"));
	}
	public static void removeSpecial(){
		String text = "This - text ! has \\ /allot #323 of % special % characters"; 
		text = text.replaceAll("[^a-zA-Z]", " "); 
		System.out.println(text); 
		String html = "This is bold"; 
		html = html.replaceAll("[^a-zA-Z0-9\\s+]", ""); 
		System.out.println(html); 

		String str="sdfvsdf68fsdfsf8999fsdf09";
		String numberOnly= str.replaceAll("[^0-9]", "");
		System.out.println("get only numbers from ====="+numberOnly);
	}
	public static void charToArray(){
		String testString = "This Is Test";
		char[] stringToCharArray = testString.toCharArray();
		for (char output : stringToCharArray) {
			//System.out.println(output);
		}

		String str = "Java String to String Array Example";
		String strArray[] = str.split(" "); 
		for(int i=0; i < strArray.length; i++){
			System.out.println(strArray[i]);
		}
	}
	public static void stringArrayToString(){
		String[] strArr = {"a","2","3"}; //or  String strArr[] = {"a","2","3"};

		//System.out.println("Hello World===="+strArr);//here o/p is Ljava.lang.String;@6d06d69c

		// System.out.println(strArr.toString());//here o/p is Ljava.lang.String;@6d06d69c

		// System.out.println(Arrays.toString(strArr));//o/p is [1,2,3]

		for(int i=0;i<strArr.length;i++){

			//   System.out.println("Hello World===="+strArr[i]);

		}

		/*List list=new ArrayList(Arrays.asList(strArr));

		System.out.println(list.get(1));*/		        

		StringBuilder sb = new StringBuilder();

		for(String str : strArr){

			sb.append(str);

			//sb.append(str+" ");//for giving space between items
		}

		String str1=sb.toString();

		System.out.println("the converted string is===="+str1);
	}
	public static void splitString(){
		/*String str="23.45";
		String[] part = str.split("\\.");
		System.out.println(part[0]);
		System.out.println(part[1]);*/

		String strComma="23,45";
		String[] comma= strComma.split(",");
		System.out.println(comma[0]);
		System.out.println(comma[1]);
	}
	public static void findCharacterNumber(){
		String str="APPLE";
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			int count=((int)c)-64;
			System.out.println(count);
		}
	}
	public static void heapToPool(){
		String s1=new String("hello");  
		String s2="hello";  
		String s3=s1.intern();//returns string from pool, now it will be same as s2  
		System.out.println(s1==s2);//false because reference is different  
		System.out.println(s2==s3);//true because reference is same  
	}
	public static void duplicateCheck(){
		String s="Ertopp";
		boolean flag=false;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			for(int j=i+1;j<s.length();j++){
				char c1=s.charAt(j);
				if(c==c1){
					flag=true;
					break;
				}
			}
			if(flag){
				System.out.println("===="+c);
				break;
			}else if((s.length()-1==i) && (flag==false)){
				System.out.println("====");
			}
		}
	}
	public static void immediateDuplicateCheck(){
		String s="hariiss";
		boolean flag=false;
		char c = 0;
		for(int i=1;i<s.length();i++){
			c=s.charAt(i);
			char c1=s.charAt(i-1);
			if(c==c1){
				/*flag=true;
				break;*/  //here first repeated value will come
				flag=true;  //here last repeated value will come
			}else{
				flag=false;
			}
		}
		if(flag){
			System.out.println(c);
		}else{
			System.out.println("no repeated duplicates");
		}		
	}
	public static void convertToString(){
		double d = 102939939.939;
		boolean b = true;
		long l = 1232874;
		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f','g' };

		System.out.println("Return Value : " + String.valueOf(d) );
		System.out.println("Return Value : " + String.valueOf(b) );
		System.out.println("Return Value : " + String.valueOf(l) );
		System.out.println("Return Value : " + String.valueOf(arr) );
	}
	public static void main(String[] args) {
		//StringPracticed.stringReverse();
		//compareToExample();
		//compareToExampleString();
		//findFrequency();
		//removingDuplicates();
		//countTokens();
		//stringCompare();
		//charToArray();
		//stringArrayToString();
		//countTokens();
		//removeSpecial();
		//splitString();
		//findCharacterNumber();
		//stringCompare();
		//heapToPool();
		//duplicateCheck();
		//immediateDuplicateCheck();
		//interviewExample();
		equalsIgnore();
	}
}
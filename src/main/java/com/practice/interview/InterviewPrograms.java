package com.practice.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class InterviewPrograms {

	public static void testVariable(){
		Float f=new Float(3.1);
		Integer i=new Integer(1);
		long l=2;

		System.out.println("testVariable===="+l+f+i);//it will do concatenation
		System.out.println("testVariable===="+l+i+f);

		int i1=2;
		int i2=5;
		double d;
		d=3+i1/i2+2;
		long i3=i1/i2;//it will come 0
		System.out.println("testVariable===="+d+"===="+i3);//5.0

		int[] array1={3,6,2,9,5,8};
		int[] array2=array1;
		int[] array3=array2;

		array1[2]=2;
		array2[3]=5;
		array3[4]=7;
		array2[4]=array3[4];
		System.out.println("array1[4]======"+array1[4]);

		int count=0;i=0;
		do{
			count +=i;
			i++;
			if(count>5)break;
		}while(i<=4);
		System.out.println("count===="+count);

		String names[]={"one","two","three"};
		for(int j=0;j<names.length;j++){
			System.out.println("names==========="+names[j]);
		}
		for (String name : names) {
			System.out.println("name==========="+name);
		}
		
		int a=5,b=7;
		int c=a+=2*3+b--;
		System.out.println("c========"+c);

		Map<Integer, Integer> map=new HashMap<>();
		map.put(1,11);
		map.put(2,22);

		Iterator iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry e=(Entry) iterator.next();
			//map.remove(e.getKey()); //java.util.ConcurrentModificationException
			iterator.remove();
			System.out.println(e.getKey());
		}

		String str="";
		StringBuilder sb=new StringBuilder();
		for(int j=0;j<50000;j++){
			str += "abc";
			sb.append("abc");
		}
		System.out.println("str======"+str);
		System.out.println("sb======"+sb);
	}
	public static void stringExample(){
		int i=9;
		String str=i>20?"greater":i>10?"medium":"small";
		System.out.println(str);
		String str1=i>20?"greater":"medium";
		System.out.println(str1);
	}
	public static void countNumbers(){
		int number = 1234; 
		int sum = 0; 
		int temp = number; 
		while (temp != 0) { 
			int lastdigit = temp % 10; 
			sum += lastdigit; 
			temp /= 10; 
		} 
		System.out.printf("Sum of digits of number %d is %d", number, sum); 
		System.out.printf("\nSum of===="+number+"====="+ sum);
	}
	@SuppressWarnings("finally")
	public static int value(){
		//the out put of this method is always 3
		try{
			System.out.println("try");
			return 1;
			//}catch(){  compile time error because catch must be a parameter
		}catch(Exception e){
			System.out.println("catch");
			return 2;
		}finally{
			System.out.println("finally");
			System.exit(1);
			return 3;
		}
	}
	public static void factorialExample(){
		int fact=1;
		for(int i=1;i<=5;i++){
			fact=fact*i;
		}
		System.out.println("Factorial of "+5+" is: "+fact);
	}
	public static void palindromExample(){
		//==================================================================================
		String str="anna";
		String temp="";
		for(int i=str.length()-1;i>=0;i--){
			temp=temp+str.charAt(i);
		}
		if(str.equals(temp)){
			System.out.println("The given string is Palindrome");
		}else{
			System.out.println("not Palindrome");
		}
		//----------------------------------------------------------------------------------
		StringBuffer sbStr=new StringBuffer(str);
		sbStr.reverse();
		if(str.equals(sbStr.toString())){
			System.out.println("====palindrome=======");
		}
		//================================================================================
		int num=12131;
		//String strNum=num+"";
		StringBuffer sb=new StringBuffer(Integer.toString(num));
		sb.reverse();
		if(num==Integer.parseInt(sb.toString())){
			System.out.println("given number is palindrome====="+sb);
		}else{
			System.out.println("is not palindrome====="+sb);
		}
	}
	static int count=0;  
	static void recursionExample(){  
		//Recursion in java is a process in which a method calls itself continuously. 
		//A method in java that calls itself is called recursive method.
		count++;  
		if(count<=5){  
			System.out.println("hello "+count);  
			recursionExample();  
		}  
	}  
	int i=3;
	int j=3;
	void sum(){
		System.out.println("The sum is ======"+(i+j));//output is 6

		//======================================
		String x = new String("xyz");  //2
		String y = "abc";  //1
		x = x + y;   //1  total 4 objects
		//=======================================
		//below code is compile time error
		/*for(int i = 0; 1; i++) {
			System.out.println("Hello");
			break;
		}*/
		//=======================================
		for(int i = 0; true; i++) {
			System.out.println("Hello"); //out put is   Hello
			break;
		}
		//========================================
		System.out.println("fun()================"+fun());//out put is 20
		//==================================================
		int x1 = 5, y1 = 5;

		System.out.println("============"+(++x1)); // outputs 6
		System.out.println(x1); // outputs 6

		System.out.println(y1++); // outputs 5
		System.out.println(y1); // outputs 6
		//=================================================

		/*int a, b;
		a=10;
		b=a++;//first assigning then incrementing
		System.out.println(a+"===b===+"+b);//output is a=11,b=10
		 */
		//============================================================
		int a, b;
		a=10;
		b=++a;
		System.out.println("a===="+a+"====b===="+b);  //output a=11,b=11 
		//===========================================================
		int a1=20;
		a1= ++a1 + 1;
		System.out.println("========a1====="+a1);//output 22
		//======================================================
		int a2=20;
		a2= a2++ + 1;
		System.out.println("a2====="+a2);//output  21
		//=====================================================
		int a3=20;
		a3= ++a3 + ++a3;
		//=21+22
		System.out.println("a3======="+a3);//output is 43
		//=======================================================
		int a4=20;
		a4= a4++ + a4++;
		System.out.println("a4======"+a4);//output is 41
		//======================================================
		int a5=20;
		a5= a5++ + ++a5;
		System.out.println(a5);//output is 42
		//======================================================
		int i;
		for (i=0; i <=19; i += 2) {  //Increment by 2
			System.out.println(i);
		} 
		//======================================================
		System.out.println("==================================");
		int j;
		for (j=20; j >= 0; j -= 2) {  //Decrement by 2
			System.out.println(j);
		} 
		int a6 = 1;
		int b6 = 2;
		int c6;
		int d6;
		c6 = ++b6;
		d6 = a6++;
		c6++;
		System.out.println("a6 ----"+a6+"=====b6-----"+b6+"===c6-----"+c6+"====d6----"+d6);//output 2,3,4,1 
	}
	int fun() {
		return 20;
	} 
	static int fun1() {
		int x= 0;
		// return x++;//output is 0
		return x++;//output is 1
	}
	//=============================
	static void parameterExample(byte b,byte b1){//1
		System.out.println("b==="+b+"===b1==="+b1);
	}
	static void parameterExample(int i,int i1){//2
		System.out.println("i==="+i+"===i1==="+i1);
	}
	//=======================
	static void objectExample(String str){
		System.out.println("string method====="+str);
	}
	static void objectExample(Object obj){
		System.out.println("object mthod ======"+obj);
	}
	public static void main(String[] args) {
		InterviewPrograms interview=new InterviewPrograms();
		/*factorialExample();
		stringExample();
		palindromExample();
		recursionExample();*/
		//countNumbers();
		//System.out.println(value());
		//stringExample();
		//interview.sum();
		//System.out.println("fun()================"+fun());//compile time error because method is non static
		//======================================
		System.out.println(fun1());
		//=================================================================
		byte b=10;byte c=1;;
		//parameterExample(b,c);//here it will call 1 method
		//parameterExample(12,2222);//here it will call 2 method
		//=================================================================
		//objectExample(null);//it will call string method because string value by default null
		Object obj=null;
		objectExample(obj);//here it will call object method


		System.out.println("=========testVariable====================");
		testVariable();
	}
}
package com.practice.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SetPracticed {

	public static void treesetExample(){
		//By using name comparator (String comparison)
		System.out.println("Name sorting ===========");
		TreeSet<TreeSetModel> nameComp = new TreeSet<TreeSetModel>(new TreeSetNameCompare());
		nameComp.add(new TreeSetModel("Ram",3000));
		nameComp.add(new TreeSetModel("John",6000));
		nameComp.add(new TreeSetModel("Crish",2000));
		nameComp.add(new TreeSetModel("Tom",2400));
		for(TreeSetModel e:nameComp){
			System.out.println(e);
		}
		System.out.println("====Salary sorting====");
		//By using salary comparator (int comparison)
		TreeSet<TreeSetModel> salComp = new TreeSet<TreeSetModel>(new TreeSetSalaryCompare());
		salComp.add(new TreeSetModel("Ram",3000));
		salComp.add(new TreeSetModel("John",6000));
		salComp.add(new TreeSetModel("Crish",2000));
		salComp.add(new TreeSetModel("Tom",2400));
		for(TreeSetModel e:salComp){
			System.out.println(e);
		}

		System.out.println("============================================");

		Set<TreeSetModel> set=new TreeSet<TreeSetModel>();
		set.add(new TreeSetModel("Ram",3000));
		set.add(new TreeSetModel("John",6000));
		set.add(new TreeSetModel("Crish",2000));
		set.add(new TreeSetModel("Tom",2400));
		set.add(new TreeSetModel("Tom",2400));
		
		//without comparable java.lang.ClassCastException
		Iterator iterator=set.iterator();
		while(iterator.hasNext()){
			TreeSetModel treeSetModel=(TreeSetModel)iterator.next();
			System.out.println("the name is ==="+treeSetModel.getName()+"====salary is==="+treeSetModel.getSalary());
		}
		
		System.out.println("=============================================");
		
		Set set1=new TreeSet();
		set1.add("B");
		set1.add("C");
		set1.add("A");
		set1.add("S");
		
		Iterator iterator1=set1.iterator();
		while(iterator1.hasNext()){
			System.out.println("the name is ==="+iterator1.next());//output is ABCS
		}
	}

	public static void main(String[] args) {
		//SetPracticed.forLoopForSet();
		treesetExample();
	}
	public static void forLoopForSet(){
		Set set=new HashSet();
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(5);

		System.out.println("======set with iterate example========");

		Iterator iterate=set.iterator();
		while(iterate.hasNext()){
			System.out.println(iterate.next());
		}	

		System.out.println("=====Set with for loop example========");

		for(Object obj:set){
			System.out.println(obj);
		}
	}
}
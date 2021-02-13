package com.practice.oops;

public class InterfacePracticeChild implements InterfacePractice{


	public static void main(String[] args) {
		InterfacePractice interfacePractice=new InterfacePracticeChild();
		System.out.println(InterfacePractice.iStatic);
		System.out.println(interfacePractice.iFinal);
	}

	@Override
	public void show() {
		
	}
}

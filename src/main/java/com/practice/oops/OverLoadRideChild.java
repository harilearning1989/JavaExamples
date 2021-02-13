package com.practice.oops;

public class OverLoadRideChild implements OverLoadRideParent {

	@Override
	public void overRide() {
		System.out.println(i);
	}
	@Override
	public void overRide(int j) {
		System.out.println(i);
	}
	@Override
	public void publicExample() {
		
	}
	public static void main(String[] args) {
		//OverLoadRideParent overLoadRideParent=new OverLoadRideParent();//we cannot create object for interface
		OverLoadRideParent overLoadRideChild=new OverLoadRideChild();
		overLoadRideChild.overRide();
		overLoadRideChild.defaultExample();
	}
}

package com.month.enm;

public class EnumMonthsDemo {

	Months month;
	public EnumMonthsDemo(Months mon) {
		this.month = mon;
	}
	public void getMyDirection() {
		switch (month) {
		case JANUARY:
			System.out.println("JANUARY");
			break;
		case FEBRUARY:
			System.out.println("FEBRUARY");
			System.out.println(month.i);
			System.out.print(month.show());
			break;
		case MAY: 
			System.out.println("MAY");
			break;
		case AUGUST: 
			System.out.println("AUGUST");
			break;
		default:
			System.out.println("Others");
			break;
		}
	}
	public static void main(String[] args) {
		//FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER;
		EnumMonthsDemo obj1 = new EnumMonthsDemo(Months.JANUARY);
		obj1.getMyDirection();
		EnumMonthsDemo obj2 = new EnumMonthsDemo(Months.FEBRUARY);
		obj2.getMyDirection();
		EnumMonthsDemo obj3 = new EnumMonthsDemo(Months.MAY);
		obj3.getMyDirection();
		EnumMonthsDemo obj4 = new EnumMonthsDemo(Months.AUGUST);
		obj4.getMyDirection();
		EnumMonthsDemo obj5 = new EnumMonthsDemo(Months.NOVEMBER);
		obj5.getMyDirection();
	}

}

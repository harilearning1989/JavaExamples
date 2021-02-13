package com.practice.oops;

public class AbstractChild extends AbstractParent {

	@Override
	public void abstractSum() {

	}
	@Override
	public void abstractSum1() {

	}
	@Override
	void abstractSumDefaultDeclaration() {

	}

	//11111====================================
	
	/*  we cannot reduce the visibility  of public
	 * @Override
	private void abstractSumPublic1() {
	}
	@Override
	protected void abstractSumPublic1() {
	}
	@Override
	void abstractSumPublic1() {
	}
	*/

	//22222 =========we can change the visibility protected to public only
	
	@Override
	public void abstractSumProtected1() {

	}
	
	/*@Override
	protected void abstractSumProtected1() {

	}*/
	
	/* COmpile time error
	 * @Override
	private void abstractSumProtected1() {

	}
	@Override
	void abstractSumProtected1() {

	}*/
	
	//33333333==========
	/*@Override
	public void abstractSumDefault1() {

	}
	@Override
	protected void abstractSumDefault1() {

	}*/
	/*@Override
	void abstractSumDefault1() {

	}*/
	/*@Override
	public void abstractSumDefault1() {

	}*/
	@Override
	protected void abstractSumDefault1() {

	}
	/*we cannot reduce the visibility
	 * @Override
	private void abstractSumDefault1() {

	}*/

	//======================================
	
	public static void main(String[] args) {
		AbstractParent abstractParent=new AbstractChild();
		//abstractParent.abstractSumPrivate(); compile time error because method signature is private
		abstractParent.abstractSumPublic();
		abstractParent.abstractSumProtected();
		abstractParent.abstractSumDefault();
		//abstractParent.abstractSumPrivate();	compile time error	
		System.out.println("=====variables========");
		//System.out.println(abstractParent.iPrivate);//compile time error 
		System.out.println(abstractParent.iDefault);
		System.out.println(iStatic);
		System.out.println(abstractParent.iFinal);
		
	}
}
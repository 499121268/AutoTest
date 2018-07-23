package com.yxk.test;

import java.io.IOException;

class demo01 {
	
	public static void main(String[] args) throws InterruptedException, IOException{
		
		
		Test t1=new Test();
		t1.setUp();
		t1.openGoogle();
		t1.login();
		Thread.sleep(2000);
		t1.switchStores();
		Thread.sleep(2000);
		//t1.newBXdan();
		
		t1.newCGdan();
		//t1.cxCGdan();
		
		t1.rf();
		
	
	}
}


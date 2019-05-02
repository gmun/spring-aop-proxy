package com.moong.proxy.business;

public class MyBusiness {

	public void doAction() {
		try {
			System.out.println("MyBusiness.doAction()");
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
	}

	public void doReady() {
		System.out.println("MyBusiness.doReady()");
	}
	
}

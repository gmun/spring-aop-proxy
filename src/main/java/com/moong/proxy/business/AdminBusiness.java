package com.moong.proxy.business;

import org.springframework.stereotype.Component;

@Component
public class AdminBusiness implements Business{
	
	@Override
	public void doAction() {
		
		try {
			System.out.println("AdminBusiness.doAction()");
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
	}

	@Override
	public void doReady() {
		System.out.println("AdminBusiness.doReady()");
	}

	
}

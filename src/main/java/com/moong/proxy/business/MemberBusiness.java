package com.moong.proxy.business;

import org.springframework.stereotype.Component;

@Component
public class MemberBusiness implements Business{

	@Override
	public void doAction() {
		try {
			System.out.println("MemberBusiness.doAction()");
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
	}

	@Override
	public void doReady() {
		System.out.println("MemberBusiness.doReady()");
	}

}

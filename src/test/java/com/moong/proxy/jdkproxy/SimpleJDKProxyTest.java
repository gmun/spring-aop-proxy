package com.moong.proxy.jdkproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.moong.proxy.business.Business;
import com.moong.proxy.business.MemberBusiness;

public class SimpleJDKProxyTest {
	
	@Test
	public void isWeaving() {
		Business member = (Business) Proxy.newProxyInstance(this.getClass().getClassLoader()
														  , new Class[] {Business.class}
														  , new MonitorHandler(new MemberBusiness()) );
		member.doAction();
	}
}

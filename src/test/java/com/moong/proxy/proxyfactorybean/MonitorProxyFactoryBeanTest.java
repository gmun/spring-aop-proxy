package com.moong.proxy.proxyfactorybean;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.moong.proxy.business.Business;
import com.moong.proxy.business.MemberBusiness;
import com.moong.proxy.business.MyBusiness;

public class MonitorProxyFactoryBeanTest {
	
	private ProxyFactoryBean factory;
	
	@Before
	public void init() {
		factory = new ProxyFactoryBean();
	}
	
	@Test
	public void isJDKDynamicProxy(){
		factory.setTarget(new MemberBusiness());
		//factory.addAdvice(new MonitorHandler());
		
		System.out.println(factory.getObjectType());
		
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("doAction");
		
		factory.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MonitorHandler()));
		
		Business member = (Business)factory.getObject(); // FactoryBean의 구현한 클래스 임으로 getObject()으로 프록시 Bean 반환받는다.
		member.doAction();
		member.doReady();
		
		assertThat(Proxy.isProxyClass(factory.getObjectType()), is(true));
	}
	
	@Test @Ignore
	public void isCGLIB(){
		factory.setTarget(new MyBusiness());
		factory.addAdvice(new MonitorHandler());
		
		MyBusiness business = (MyBusiness) factory.getObject();
		
		System.out.println(factory.getObjectType());
		assertThat(Proxy.isProxyClass(factory.getObjectType()), is(true));
		business.doAction();
		
	}
	
	
}

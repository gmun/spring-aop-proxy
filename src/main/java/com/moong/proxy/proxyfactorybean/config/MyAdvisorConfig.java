package com.moong.proxy.proxyfactorybean.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.moong.proxy.proxyfactorybean.MonitorHandler;

@Configurable
public class MyAdvisorConfig {

	@Bean
	public Pointcut businessPointcut() {
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("do*");
		return pointcut;
	}
	
	@Bean
	public Advice monitorAdvice() {
		return new MonitorHandler();
	}
	
	@Bean 
	public Advisor myAdvisor() {
		return new DefaultPointcutAdvisor(businessPointcut(), monitorAdvice());
	}
}
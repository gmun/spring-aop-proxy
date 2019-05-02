package com.moong.proxy.jdkproxy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.moong.proxy.business.Business;
import com.moong.proxy.business.MemberBusiness;
import com.moong.proxy.jdkproxy.MonitorFactoryBean;

@Configurable
public class MyBeanConfig {

	@Bean
	public MonitorFactoryBean monitorFactoryBean () {
		MonitorFactoryBean factory = new MonitorFactoryBean();
		factory.setInterfaces(Business.class);
		factory.setTarget(new MemberBusiness());
		return factory;
	}
}

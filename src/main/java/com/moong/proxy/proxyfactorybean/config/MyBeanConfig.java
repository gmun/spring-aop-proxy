package com.moong.proxy.proxyfactorybean.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.moong.proxy.business.MemberBusiness;

@Configurable
@Import(MyAdvisorConfig.class)
public class MyBeanConfig {
	
	@Bean
	public ProxyFactoryBean factoryBean() {
		ProxyFactoryBean factory = new ProxyFactoryBean();
		factory.setTarget(new MemberBusiness());

		//어드바이스와 어드바이저를 동시에 설정할 수 있는 프로퍼티이다. String 타입 구성되어 있으며, 어드바이스나 어드바이저의 Bean 아이디 값으로 넣어주면 된다.
		factory.setInterceptorNames( new String[]{"myAdvisor"} );
		return factory;
	}
}

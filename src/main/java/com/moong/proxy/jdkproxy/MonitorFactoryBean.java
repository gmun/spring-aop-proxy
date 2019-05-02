package com.moong.proxy.jdkproxy;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;

import lombok.Setter;

@Setter
public class MonitorFactoryBean implements FactoryBean<Object>{
	private Class<?> interfaces;	// 다이나믹 프록시를 생성할 때 필요하다. UserService 외의 인터페이스를 가진 타깃에도 적용
	private Object 	 target;
	
	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(getClass().getClassLoader()
									, new Class[] {interfaces}
									, new MonitorHandler(target));
	}

	@Override
	public Class<?> getObjectType() {
		return interfaces;
	}
}

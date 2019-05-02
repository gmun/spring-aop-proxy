package com.moong.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.util.StopWatch;

//@RequiredArgsConstructor

public class MonitorHandler implements InvocationHandler{

	private Object target;
	
	public MonitorHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		proxy = method.invoke(target, args);
		
		stopWatch.stop();
		System.out.format("%s result : %s\n\n", method.getName(), stopWatch.getLastTaskTimeMillis());
		return proxy;
	}
}

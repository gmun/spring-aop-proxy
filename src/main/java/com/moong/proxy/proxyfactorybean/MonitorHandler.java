package com.moong.proxy.proxyfactorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class MonitorHandler implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object target = invocation.proceed();
		
		stopWatch.stop();
		System.out.format("result : %s\n\n", stopWatch.getLastTaskTimeMillis());
		
		return target;
	}

}

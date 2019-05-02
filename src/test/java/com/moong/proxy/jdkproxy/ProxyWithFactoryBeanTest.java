package com.moong.proxy.jdkproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.moong.proxy.business.Business;
import com.moong.proxy.jdkproxy.config.MyBeanConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= {MyBeanConfig.class})
public class ProxyWithFactoryBeanTest {
	
	@Autowired
	private Business memberBusiness;
	
	@Test
	public void isWeaving() throws Exception {
		memberBusiness.doAction();
	}

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void isContextBeanConfigTest() throws Exception {
		/**
		 * 팩토리 빈이 만들어주는 빈 오브젝트가 아닌 픽토리 빈 자체를 가져오고 싶을 경우엔
		 * getBean 메소드에 '&'를 빈 이름 앞에 붙여주면 팩토리 빈 자체를 반환한다.
		 * */
		MonitorFactoryBean factory = (MonitorFactoryBean) context.getBean("&monitorFactoryBean");
		Business business = (Business) factory.getObject();
		business.doAction();
	}
	
}

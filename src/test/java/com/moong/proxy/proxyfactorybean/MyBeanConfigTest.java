package com.moong.proxy.proxyfactorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.moong.proxy.business.Business;
import com.moong.proxy.proxyfactorybean.config.MyBeanConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= {MyBeanConfig.class})
public class MyBeanConfigTest {

	@Autowired
	private Business memberBusiness;
	
	@Test
	public void isWeaving() {
		memberBusiness.doAction();
	}
}

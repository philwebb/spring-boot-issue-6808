package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

//@RunWith(SpringRunner.class)
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class PowermockClassLoadTest {

	@Autowired
	private ConfigurableApplicationContext context;

	@Test
	public void testRest() throws Exception {
		BeanDefinition definition = context.getBeanFactory().getBeanDefinition("powermockClassLoadTest.Config");
		String className = definition.getBeanClassName();
		ClassUtils.forName(className, null);
	}

	@Configuration
	public static class Config {
	}

}

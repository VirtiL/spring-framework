package com.tuling.aop;

import com.tuling.UserService;
import com.tuling.aop.advice.ZhouyuAroundAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周瑜
 */
@Configuration
public class ProxyFactoryBeanDemo {


	@Bean
	public ZhouyuAroundAdvice zhouyuAroundAdvise() {
		return new ZhouyuAroundAdvice();
	}


	@Bean
	public ProxyFactoryBean userService() {
		UserService userService = new UserService();

		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyTargetClass(true);
		proxyFactoryBean.setTarget(userService);
		proxyFactoryBean.setInterceptorNames("zhouyuAroundAdvise");
		return proxyFactoryBean;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ProxyFactoryBeanDemo.class);
		UserService userService = applicationContext.getBean("userService", UserService.class);
		userService.test();
	}
}

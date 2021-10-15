package com.tuling.aop;

import com.tuling.UserService;
import com.tuling.aop.advice.ZhouyuAroundAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周瑜
 */
@Configuration
public class BeanNameAutoProxyCreatorDemo {

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public ZhouyuAroundAdvice zhouyuAroundAdvise() {
		return new ZhouyuAroundAdvice();
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("userSe*");
		beanNameAutoProxyCreator.setInterceptorNames("zhouyuAroundAdvise");
		beanNameAutoProxyCreator.setProxyTargetClass(true);

		return beanNameAutoProxyCreator;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(BeanNameAutoProxyCreatorDemo.class);

		UserService userService = applicationContext.getBean("userService", UserService.class);
		userService.test();
	}
}

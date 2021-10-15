package com.tuling.aop;

import com.tuling.UserService;
import com.tuling.aop.advice.ZhouyuAroundAdvice;
import com.tuling.aop.advice.ZhouyuThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Factory;

/**
 * @author 周瑜
 */
public class AdviceDemo {

	public static void main(String[] args) {
		UserService userService = new UserService();

		ProxyFactory proxyFactory = new ProxyFactory(userService);
		proxyFactory.addAdvice(new ZhouyuAroundAdvice());
		UserService proxy = (UserService) proxyFactory.getProxy();

		System.out.println(proxy instanceof Factory);
	}
}

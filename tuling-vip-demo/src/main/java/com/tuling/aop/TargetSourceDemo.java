package com.tuling.aop;

import com.tuling.UserService;
import com.tuling.aop.advice.ZhouyuBeforeAdvice;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author 周瑜
 */
public class TargetSourceDemo {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTargetSource(new TargetSource() {
			@Override
			public Class<?> getTargetClass() {
				return UserService.class;
			}

			@Override
			public boolean isStatic() {
				return true;
			}

			@Override
			public Object getTarget() throws Exception {
				return new UserService();
			}

			@Override
			public void releaseTarget(Object target) throws Exception {

			}
		});

		proxyFactory.addAdvice(new ZhouyuBeforeAdvice());
		proxyFactory.setProxyTargetClass(true);
		proxyFactory.setFrozen(true); // frozen和static都为true，可以使得代理对象执行方法是保证被代理对象是同一个

		UserService proxy = (UserService) proxyFactory.getProxy();
		proxy.test();
		proxy.test();
	}
}

package com.tuling.cglib;

import com.tuling.UserInterface;
import com.tuling.UserService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author 周瑜
 */
public class Main {

	public static void main(String[] args) {
		UserService target = new UserService();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);
		enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("before...");
//				Object result = method.invoke(o, objects);
//				Object result = methodProxy.invokeSuper(o, objects);
				Object result = methodProxy.invoke(target, objects);
				System.out.println("after...");
				return result;
			}
		},  NoOp.INSTANCE});
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if (method.getName().equals("test") || method.getName().equals("b")) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		enhancer.setInterfaces(new Class[]{UserInterface.class});

		UserService userService = (UserService) enhancer.create();
		userService.test();

//		userService.b("zhouyu");

//		UserInterface userInterface = (UserInterface) userService;
//		System.out.println(userInterface);
	}
}

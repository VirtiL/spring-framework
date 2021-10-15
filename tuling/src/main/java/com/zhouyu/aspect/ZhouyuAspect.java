package com.zhouyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.tools.JoinPointMatch;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class ZhouyuAspect {

//	@DeclareParents(value = "com.zhouyu.service.UserService", defaultImpl = UserImplement.class)
//	private UserInterface userInterface;

	@Before("execution(public void com.zhouyu.service.UserService.test())")
	public void zhouyuBefore(JoinPoint joinPoint) {
		System.out.println("zhouyuBefore");
	}

//	@Before(value = "execution(public void com.zhouyu.service.UserService.test(..)) && args(a, b)", argNames = "a,b")
//	public void zhouyuBefore(String a, String b) {
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println("zhouyuBefore");
//	}


}

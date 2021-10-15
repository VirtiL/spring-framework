package com.tuling.aop;

import com.tuling.aop.introduction.CustomInterface;
import com.tuling.aop.introduction.CustomService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Annotation;

/**
 * @author 周瑜
 */
@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class IntroductionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(IntroductionDemo.class);
		CustomService customService = applicationContext.getBean(CustomService.class);
		CustomInterface customInterface = (CustomInterface) customService;
		customInterface.custom();

//		System.out.println(customService.getClass().isAnnotationPresent(CustomAnnotation.class));

		for (Annotation annotation : customService.getClass().getDeclaredAnnotations()) {
			System.out.println(annotation.getClass());
		}
	}
}

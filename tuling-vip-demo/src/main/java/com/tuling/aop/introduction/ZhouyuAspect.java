package com.tuling.aop.introduction;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 周瑜
 */
@Aspect
@Component
public class ZhouyuAspect {

	@DeclareParents(value = "com.tuling.aop.introduction.CustomService", defaultImpl = DefaultCustomInterface.class)
	private CustomInterface customInterface;

}

package com.tuling.xml.controller.custom;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface SessionMapping {

    /**
     * 映射的 URL 地址
     * @return
     */
    String value() default "";
}

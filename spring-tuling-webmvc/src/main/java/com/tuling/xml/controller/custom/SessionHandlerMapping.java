package com.tuling.xml.controller.custom;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 自定义根据session映射的 映射器
 */
@Component
@Order(0)
public class SessionHandlerMapping  extends RequestMappingHandlerMapping {


    // 重写 获取@RquestMapping注解属性  改成获取 @SessionMapping的属性
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {

        RequestMappingInfo info = null;

        SessionMapping methodAnnotation = AnnotationUtils.findAnnotation(method, SessionMapping.class);
        if (methodAnnotation != null) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);
            info = createRequestMappingInfo(methodAnnotation, methodCondition);
        }
        return info;
    }

    // 重写根据@RquestMapping 场景RequestMappingInfo ， 现在根据SessionMapping 创建
    protected RequestMappingInfo createRequestMappingInfo(
            SessionMapping requestMapping, @Nullable RequestCondition<?> customCondition) {
        // 将@RequestMapping注解属性的值构建成一个 RequestMappingInfo
        RequestMappingInfo.Builder builder = RequestMappingInfo
                //构建路径
                .paths(requestMapping.value())
                .mappingName(requestMapping.value())
                //构建方法(get)
                .methods(RequestMethod.GET);
        if (customCondition != null) {
            builder.customCondition(customCondition);
        }
        // 构造RequestMappingInfo：将上面的属性构建成一个个的RequestCondition对象方便在请求的时候组合匹对
        return builder.build();
    }


    // 这里就是请求的时候调用的方法了
    // 重写， 之前获取request的请求路径，， 现在拿到session中的path路径进行匹配
    @Override
    protected String initLookupPath(HttpServletRequest request) {
        String path= null;
        HttpSession session = request.getSession();
        if(null!=session.getAttribute("path")){
            path = (String) session.getAttribute("path");
        }
        return path;
    }

    // 这里重写下， 如果我上面返回null就不匹配了
    @Override
    protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
        if(lookupPath==null){
            return null;
        }
        return super.lookupHandlerMethod(lookupPath, request);
    }
}

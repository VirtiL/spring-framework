package com.tuling.servletweb.spi;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@HandlesTypes(WebApplicationInitializer.class)
public class TulingSpringServletContainerInitializer extends SpringServletContainerInitializer {

    /**
     *
     * @param webAppInitializerClasses 感兴趣类的集合
     * @param servletContext Tomcat传过来的一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {

        // 通过servletContext动态添加Servlet
        servletContext.addServlet("spiServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.getWriter().write("spiServlet--doGet");
            }
        }).addMapping("/spiServlet.do");


    }
}

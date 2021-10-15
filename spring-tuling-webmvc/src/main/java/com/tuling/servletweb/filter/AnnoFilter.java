package com.tuling.servletweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@WebFilter("*.do")
public class AnnoFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AnnoFilter——init-");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("AnnoFilter——doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("AnnoFilter——destroy");
    }
}

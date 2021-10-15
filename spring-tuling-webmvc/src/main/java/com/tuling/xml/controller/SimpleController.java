package com.tuling.xml.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 * DefaultAnnotationHandlerMapping
 * SimpleControllerHandlerAdapter
 */
@Component
public class SimpleController implements Controller {

    @Override 
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("SimpleController Working.");
        ModelAndView modelAndView = new ModelAndView("a");
        modelAndView.addObject("source","SimpleController");
        return modelAndView;
    }
}
package com.tuling.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
@RequestMapping("/request")
public class RequestMappingController {

    @RequestMapping("/mapping")
    public ModelAndView mapping(){
        System.out.println("RequestMappingController Working.");
        ModelAndView modelAndView = new ModelAndView("a");
        modelAndView.addObject("source","RequestMappingController");
        return modelAndView;
    }

    // localhost:8080/springmvc/mapping/ant1

    @RequestMapping(value="/mappin*")
    public String mapping08(){
        System.out.println("通配符——*");
        return "/a.jsp";
    }
    @RequestMapping(value="/mappin?")
    public String mapping07(){
        System.out.println("通配符——？");
        return "/a.jsp";
    }
    @RequestMapping(value="/{mapping}")
    public String mapping07(@PathVariable String mapping){
        System.out.println("PathVariable");
        return "/a.jsp";
    }


    @ResponseBody
    @RequestMapping("/updateUser2")
    public List updateUser2(Integer id, String lastName) {
        System.out.println(lastName);

        // 看看能不能转json
        return Arrays.asList(id,lastName) ;
    }

}

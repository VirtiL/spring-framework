package com.tuling.xml.controller.custom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
public class SessionMappingController {

    @RequestMapping("/xushu/set/{value}")
    public String set(@PathVariable("value") String value, HttpSession session){
        session.setAttribute("path","/xushu/"+value);
        return "a";
    }
    @RequestMapping("/xushu/clear")
    public String clear(HttpSession session){
        session.setAttribute("path",null);
        return "a";
    }


    @SessionMapping("/xushu/add")
    public String add(){
        System.out.println("add");
        return "a";
    }

    @SessionMapping("/xushu/query")
    public String query(){
        System.out.println("query");
        return "a";
    }

}

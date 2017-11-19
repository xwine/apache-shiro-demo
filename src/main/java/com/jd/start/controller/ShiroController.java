package com.jd.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenjunjun on 2017/11/14.
 */
@Controller
public class ShiroController {

    @RequestMapping("/hello")
    public ModelAndView helloShiro(){
        String message = "<h1>Hello Shiro</h1>";
        return new ModelAndView("success.jsp","message",message);
    }
}

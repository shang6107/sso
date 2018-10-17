package com.shuimentech.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class ViewController {

    @RequestMapping("/index.do")
    public String showIndex(HttpServletRequest request, HttpServletResponse response) {
        Principal principal = request.getUserPrincipal();
        if(principal != null){
            request.getSession().setAttribute("user", principal.getName());
        }
        return "index";
    }

}

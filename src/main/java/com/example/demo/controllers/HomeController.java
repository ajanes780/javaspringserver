package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {


    private static final String template = " <h1> Welcome to the server  %s! </h1>";

    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");

        return String.format(template, name.substring(0, 1).toUpperCase() + name.substring(1));
    }


    @RequestMapping("/page1")
    @ResponseBody
    public String page1() {
        return " <h1> Welcome to page 1 </h1>";
    }


}

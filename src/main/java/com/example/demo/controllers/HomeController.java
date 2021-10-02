package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return " <h1> Welcome to the server </h1>";
    }


    @RequestMapping("/page1")
    @ResponseBody
    public String page1() {
        return " <h1> Welcome to page 1 </h1>";
    }


}

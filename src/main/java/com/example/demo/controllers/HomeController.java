package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final String template = " <h1> Welcome to the server  %s! </h1>";

    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null) {
            name = "Jedi";
        }

        return String.format(template, name.substring(0, 1).toUpperCase() + name.substring(1));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody()
    public String helloForm() {
        return
                "<h1> Welcome to the server young Padawan</h1> " +
                        "<p> What is your name</p>" +
                        "<form method='post'> " +
                        "<input type='text' name='name' />" +
                        "<input type='submit' value='Greet Me !'/>" +
                        "</form";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody()
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == "") {
            name = "Jedi";

        }
        return String.format(template, name.substring(0, 1).toUpperCase() + name.substring(1));
    }

    @RequestMapping("/page1")
    @ResponseBody
    public String page1() {
        return " <h1> Welcome to page 1 </h1>";
    }


}

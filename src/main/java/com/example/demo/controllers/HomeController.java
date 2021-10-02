package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final String template = "<h1> Welcome to the server young %s! </h1>";
    private static final String templateForm = "<h1> Welcome to the server young Padawan</h1> " +
            "<h3> What is your name</h3>" +
            "<form method='post'> " +
            "<input type='text' name='name' />" +
            "<input type='submit' value='Greet Me !'/>" +
            "</form";


    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null) {
            name = "Padawan";
        }

        return String.format(template, name.substring(0, 1).toUpperCase() + name.substring(1));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody()
    public String helloForm() {
        return templateForm;

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

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody()
    public String helloUrlSegment(@PathVariable String name) {
        return String.format(template, name.substring(0, 1).toUpperCase() + name.substring(1));

    }


    @RequestMapping("/*")
    public String page1() {
        return "redirect:/hello";
    }


}

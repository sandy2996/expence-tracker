package com.santhosh.demo.expense.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(path = "/")
    public String home(Model model) {
        model.asMap().forEach((key, val) -> System.out.println(key+" : "+val));
        return "index";
    }
}

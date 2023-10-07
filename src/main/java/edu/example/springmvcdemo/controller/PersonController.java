package edu.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {
    @GetMapping("/hey")
    public String heyPerson() {
        return "heyPerson";
    }

    @GetMapping("")
    @ResponseBody
    public String person() {
        return "heyPerson json";
    }
}

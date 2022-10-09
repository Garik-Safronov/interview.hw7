package ru.gb.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class HomeController {

    @GetMapping
    public String home() {
        return "start-page";
    }
}

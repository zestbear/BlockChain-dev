package com.develop.all.about.BlockChain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

}

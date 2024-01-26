package com.automated.trading.stock.StockManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

}

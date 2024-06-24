package com.bechtle_dhbw.uniProjectPasswordGame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/") //sets URL path to file
    public String test() {
        return "test"; //return templates/test.html
    }
}


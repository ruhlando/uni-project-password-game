package com.bechtle_dhbw.uniProjectPasswordGame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerClass {

    private final ModelClass passwordValidator;

    public ControllerClass() {
        this.passwordValidator = new ModelClass();
    }

    @GetMapping(value = "/")
    //sets URL path to file
    public String showForm() {
        return "index";
    }

    @PostMapping("/password-game")
    public String validatePassword(@RequestParam("password") String password, Model model) {
        boolean isValid = passwordValidator.isValidPassword(password);
        model.addAttribute("isValid", isValid);
        model.addAttribute("password", password);
        return "index";
    }

}


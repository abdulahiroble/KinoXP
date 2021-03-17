package com.kinoxp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        // userModel.addAttribute("userModel", userModel);
        return "login";
    }

    @GetMapping("/createaccount")
    public String createAccount(Model userModel) {
        userModel.addAttribute("userModel", userModel);
        return "createaccount";
    }

}

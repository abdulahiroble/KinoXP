package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.User;
import com.kinoxp.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmployeeController {


    @GetMapping("/createemployee")
    public String createAccount(Model userModel) {
        userModel.addAttribute("user", new User());
        return "createemployee";
    }
}

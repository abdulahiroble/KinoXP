package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.User;
import com.kinoxp.demo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserRepository userRepository;

    // @PostMapping(value="/newuser", consumes = "application/json")
    // @ResponseStatus(HttpStatus.CREATED)
    // public User newuser(@RequestBody User user) {

    //     // try {
    //     //     userRepository.save(user);
    //     // } catch (Exception e) {
    //     //     System.out.println("Error can't save to database " + e);
    //     // }
    
    //     // return "redirect:/register_success";
        
    //     System.out.println(user);
    //     return userRepository.save(user);
    // }
    
}

package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.User;
import com.kinoxp.demo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class LoginController {

    private UserRepository userRepository;
    // private User user;

    // private BookRepository bookRepository;
    // private final PublisherRepository publisherRepository;
    // private final AuthorRepository authorRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        // userModel.addAttribute("userModel", userModel);
        return "login";
    }

    @PostMapping(value="/newuser", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User newuser(@RequestBody User user) {

        // try {
        //     userRepository.save(user);
        // } catch (Exception e) {
        //     System.out.println("Error can't save to database " + e);
        // }
    
        // return "redirect:/register_success";
        
        System.out.println(user);
        return userRepository.save(user);
    }


    @GetMapping("/createaccount")
    public String createAccount(Model userModel) {
        userModel.addAttribute("user", new User());
        return "createaccount";
    }

}

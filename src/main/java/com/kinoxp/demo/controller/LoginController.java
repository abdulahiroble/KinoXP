package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.User;
import com.kinoxp.demo.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    private UserRepository userRepository;

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

    @PostMapping("/newuser")
    @ResponseStatus(HttpStatus.CREATED)
    public String postUser(User user) {
        System.out.println(user);
        userRepository.save(user);


        return "register_success";
    }


    @GetMapping("/createaccount")
    public String createAccount(Model userModel) {
        userModel.addAttribute("user", new User());
        return "createaccount";
    }

}

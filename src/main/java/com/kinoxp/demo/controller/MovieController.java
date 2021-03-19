package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    
    @GetMapping("/createmovie")
    public String createmovie(Model movie) {

        movie.addAttribute("movie", new Movie());

        return "createmovie";
    }


    }


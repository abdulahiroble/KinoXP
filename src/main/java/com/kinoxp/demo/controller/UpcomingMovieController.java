package com.kinoxp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpcomingMovieController {

    @GetMapping("/upcoming")
    public String getUpcomingPage() {

        return "upcoming";
    }
}

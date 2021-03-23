package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class MovieRestController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/newmovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmovie(@ModelAttribute("movie") Movie movie) {

        // try {
        // userRepository.save(user);
        // } catch (Exception e) {
        // System.out.println("Error can't save to database " + e);
        // }

        // return "redirect:/register_success";

        System.out.println(movie);
        return movieRepository.save(movie);
    }

    @PostMapping(value = "/newmoviejs", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmoviejs(@RequestBody Movie movie) {
        System.out.println(movie);
        return movieRepository.save(movie);
    }

}

package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Screening;
import com.kinoxp.demo.repositories.MovieRepository;
import com.kinoxp.demo.repositories.ScreeningRepositoy;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ScreeningRestController {

    ScreeningRepositoy screeningRepository;

    MovieRepository movieRepository;

    public ScreeningRestController(ScreeningRepositoy screeningRepositoy, MovieRepository movieRepository) {
        this.screeningRepository = screeningRepositoy;
        this.movieRepository = movieRepository;
    }

    @PostMapping(value = "/newscreen", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Screening postScreening(@RequestBody Screening screening) {

        System.out.println(screening);

        return screeningRepository.save(screening);
    }

}

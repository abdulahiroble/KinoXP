package com.kinoxp.demo.controller;

import java.util.List;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.repositories.GenreRepository;
import com.kinoxp.demo.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/newmovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmovie(@ModelAttribute("movie") Movie movie) {

        System.out.println(movie);
        return movieRepository.save(movie);
    }

    @PostMapping(value = "/newmoviejs", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmoviejs(@RequestBody Movie movie) {
        System.out.println(movie);
        return movieRepository.save(movie);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/genres")
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

}

package com.kinoxp.demo.controller;

import java.util.List;
import java.util.Optional;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.repositories.GenreRepository;
import com.kinoxp.demo.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class MovieRestController {

    MovieRepository movieRepository;

    GenreRepository genreRepository;

    // ScreeningRepositoy screeningRepository;

    // MovieRepository movieRepository;

    public MovieRestController(GenreRepository genreRepository, MovieRepository movieRepository) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }

    @PostMapping("/newmovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmovie(@ModelAttribute("movie") Movie movie) {

        System.out.println(movie);
        return movieRepository.save(movie);
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> findGenreById(@PathVariable Integer id, Model genres) {
        Optional<Genre> genre = genreRepository.findById(id);

        genres.addAttribute("genre", genre);

        if (genre.isPresent()) {
            Genre realGenre = genre.get();
            return new ResponseEntity<>(realGenre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/newmoviejs", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newmoviejs(@RequestBody Movie movie, Model model) {

        Genre genrex = movie.getGenre();

        int y = Integer.parseInt(genrex.getGenre());

        genrex.setGenreid(y);

        // int x = Integer.parseInt(genrex.setGenreid(movie.getGenre().getGenreid()));

        // movie.getGenre().setGenre(genrex);

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

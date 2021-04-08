package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.repositories.GenreRepository;
import com.kinoxp.demo.repositories.MovieRepository;
import com.kinoxp.demo.service.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    private GenreRepository genreRepository;

    @GetMapping("/moviecalendar")
    public String movieCalendar(Model movie, Model genre) {

        movie.addAttribute("movie", new Movie());

        // Page<Genre> page = movieService.showGenreLists();

        // List<Genre> listGenre = genreRepository.findAll();

        // genre.addAttribute("listGenre", listGenre);

        // genre.addAttribute("genre", new Genre());

        return "moviecalendar";
    }

    @GetMapping("/createmovie")
    public String createmovie(Model movie, Model genre) {

        movie.addAttribute("movie", new Movie());

        // Page<Genre> page = movieService.showGenreLists();

        // List<Genre> listGenre = genreRepository.findAll();

        // genre.addAttribute("listGenre", listGenre);

        // genre.addAttribute("genre", new Genre());

        return "createmovie";
    }

    public List<Genre> showGenreLists(Model genre) {

        List<Genre> listGenre = genreRepository.findAll();

        genre.addAttribute("listGenre", listGenre);

        return genreRepository.findAll();
    }

    @GetMapping("/seemovie")
    public String seemovie(Model movie) {

        // movie.addAttribute("movie", new Movie());

        return showMovieList(1, movie);
    }

    @GetMapping("/deletemovie/{movieid}")
    public String deletemovie(@PathVariable(value = "movieid") int movieid) {

        try {
            this.movieService.deletemovie(movieid);
        } catch (Exception e) {
            System.out.println("Error can't delete user " + e);
        }

        return "redirect:/seemovie";
    }

    @GetMapping("/movieFormUpdate/{movieid}")
    public String movieFormUpdate(@PathVariable(value = "movieid") int movieid, Model model) {

        try {
            Movie movie = movieService.getMovieById(movieid);

            model.addAttribute("movie", movie);
        } catch (Exception e) {
            System.out.println("Error can't update user profile " + e);
        }

        return "updatemovie";
    }

    @PostMapping("/savemovie")
    public String savemovie(@ModelAttribute("movie") Movie movie) {

        try {
            movieService.savemovie(movie);
        } catch (Exception e) {
            System.out.println("Error can't save to database " + e);
        }

        return "redirect:/seemovie";
    }

    @GetMapping("/movie/{movieNo}")
    public String showMovieList(@PathVariable(value = "movieNo") int pageNo, Model model) {

        try {
            int pageSize = 10;

            Page<Movie> page = movieService.showMovieList(pageNo, pageSize);

            // Page<Genre> pages = movieService.showGenreLists(pageNo, pageSize);

            List<Movie> listMovie = page.getContent();

            // List<Genre> listGenre = pages.getContent();

            model.addAttribute("listMovie", listMovie);

            // model.addAttribute("listGenre", listGenre);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }

        return "seemovie";
    }

}

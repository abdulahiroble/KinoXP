package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.service.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    
    @GetMapping("/createmovie")
    public String createmovie(Model movie) {

        movie.addAttribute("movie", new Movie());

        return "createmovie";
    }

        
    @GetMapping("/seemovie")
    public String seemovie(Model movie) {

        // movie.addAttribute("movie", new Movie());

        return showMovieList(1, movie);
    }

    @GetMapping("/movie/{movieNo}")
    public String showMovieList(@PathVariable(value = "movieNo") int pageNo, Model model) {

        try {
            int pageSize = 10;

            Page<Movie> page = movieService.showMovieList(pageNo, pageSize);

            List<Movie> listMovie = page.getContent();

            model.addAttribute("listMovie", listMovie);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }

        return "seemovie";
    }
    


    }


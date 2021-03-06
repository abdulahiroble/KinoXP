package com.kinoxp.demo.service;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.repositories.GenreRepository;
import com.kinoxp.demo.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {
    // Page<Movie> showMovieList(int pageNo, int pageSize);

    @Autowired
    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    @Override
    public void savemovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void deletemovie(int movieid) {
        this.movieRepository.deleteById(movieid);
    }

    @Override
    public Movie getMovieById(int movieid) {
        Optional<Movie> optional = movieRepository.findById(movieid);
        Movie user = null;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found by id " + movieid);
        }
        return user;
    }

    @Override
    public Page<Movie> showMovieList(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.movieRepository.findAll(pageable);
    }

    // @Override
    // public Page<Genre> showGenreLists(int pageNo, int pageSize) {

    // Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

    // return this.genreRepository.findAll(pageable);
    // }

}

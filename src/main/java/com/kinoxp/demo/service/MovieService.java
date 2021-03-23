package com.kinoxp.demo.service;

import java.util.List;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;

import org.springframework.data.domain.Page;

public interface MovieService {
        Page<Movie> showMovieList(int pageNo, int pageSize);

        // Page<Genre> showGenreLists(int pageNo, int pageSize);

        Movie getMovieById(int movieid);

}

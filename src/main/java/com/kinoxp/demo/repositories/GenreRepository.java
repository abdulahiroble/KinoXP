package com.kinoxp.demo.repositories;

import com.kinoxp.demo.model.Genre;
import com.kinoxp.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}

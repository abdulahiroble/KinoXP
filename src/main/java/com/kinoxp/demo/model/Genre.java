package com.kinoxp.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid")
    private int genreid;

    @Column(name = "genre")
    private String genre;

    @OneToMany
    @JoinColumn(name = "genreid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "movieid")
    private Set<Movie> movie = new HashSet<>();

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {

    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovie() {
        return movie;
    }

    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }
}

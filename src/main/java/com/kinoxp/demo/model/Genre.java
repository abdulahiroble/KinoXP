package com.kinoxp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreid;

    private String genre;

    // @OneToOne
    // @MapsId
    // @JoinColumn(name = "genreid")
    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    // property = "genreid")
    // private Movie movie;

    public Genre() {

    }

    public Genre(String genre) {
        this.genre = genre;
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
}

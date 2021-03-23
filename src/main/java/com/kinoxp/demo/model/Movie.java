package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieid")
    private Integer movieid;

    @Column(name="title")
    private String title;

    @Column(name="actor")
    private String actor;

    @Column(name="age")
    private int age;

    @Column(name="length")
    private int length;

    @OneToMany
    @JoinColumn(name = "movieid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "screeningid")
    private Set<Screening> screenings = new HashSet<>();



    @ManyToOne
    @JoinColumn(name = "genreid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "genreid")
    private Genre genre;

    public Movie(String title, String actor, int age, int length, Genre genre) {
        this.title = title;
        this.actor = actor;
        this.age = age;
        this.length = length;
        this.genre = genre;
    }

// @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    // private Genre genre;

    public Movie(String title, String actor, int age, int length) {
        this.title = title;
        this.actor = actor;
        this.age = age;
        this.length = length;
    }

    // public void setGenre(Genre genre) {
    // this.genre = genre;
    // }

    // public Genre getGenre() {
    // return genre;
    // }



    public Movie() {

    }

    @Override
    public int hashCode() { return Objects.hash(movieid); }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Screening> getScreenings() { return screenings; }

    public void setScreenings(Set<Screening> screenings) { this.screenings = screenings; }

    public Genre getGenre() { return genre; }

    public void setGenre(Genre genre) { this.genre = genre; }
}

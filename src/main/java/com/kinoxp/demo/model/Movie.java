package com.kinoxp.demo.model;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "movieid")
    private int movieid;

    private String title;

    private String actor;
    private int age;
    private int length;
    private String date;
    private int time;
    private String hall;

    // @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    // private Genre genre;

    public Movie(String title, String actor, int age, int length, String date, int time, String hall) {
        this.title = title;
        this.actor = actor;
        this.age = age;
        this.length = length;
        this.date = date;
        this.time = time;
        this.hall = hall;
    }

    // public void setGenre(Genre genre) {
    // this.genre = genre;
    // }

    // public Genre getGenre() {
    // return genre;
    // }

    public Movie() {

    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

}

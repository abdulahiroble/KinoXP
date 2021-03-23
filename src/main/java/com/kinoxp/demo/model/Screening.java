package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screeningid;

    private Date screeningDate;
    private Time screeningTime;
    private int hall;

    @ManyToOne
    @JoinColumn(name = "movieid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "movieid")
    private Movie movie;

    public Screening() {

    }

    public Screening(java.sql.Date screeningDate, Time screeningTime, Movie movie, int hall) {
        this.screeningDate = screeningDate;
        this.screeningTime = screeningTime;
        this.hall = hall;
        this.movie = movie;
    }
}

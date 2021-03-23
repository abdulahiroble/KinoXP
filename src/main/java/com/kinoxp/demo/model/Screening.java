package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screeningid;

    @Column(name = "screendt")
    private Date screeningDate;

    @Column(name = "screentm")
    private Time screeningTime;

    private int hall;

    @ManyToOne
    @JoinColumn(name = "movieid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "movieid")
    private Movie movie;

    @OneToMany
    @JoinColumn(name = "screeningid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationid")
    private Set<Reservation> reservation = new HashSet<>();

    public Screening() {

    }

    public Screening(Date screeningDate, Time screeningTime, int hall) {
        this.screeningDate = screeningDate;
        this.screeningTime = screeningTime;
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Screening screening = (Screening) o;
        return Objects.equals(screeningid, screening.screeningid);
    }

    public Screening(Date screeningDate, Time screeningTime, Movie movie, int hall) {
        this.screeningDate = screeningDate;
        this.screeningTime = screeningTime;
        this.hall = hall;
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(screeningid);
    }

    public Set<Reservation> getReservation() {
        return reservation;
    }

    public void setScreenings(Set<Reservation> reservation) {
        this.reservation = reservation;
    }

    public int getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }

    public Time getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Time screeningTime) {
        this.screeningTime = screeningTime;
    }

    public int getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }
}

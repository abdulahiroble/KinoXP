package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    public Screening(java.sql.Date screeningDate, Time screeningTime, Movie movie, int hall) {
        this.screeningDate = screeningDate;
        this.screeningTime = screeningTime;
        this.hall = hall;
        this.movie = movie;
    }

    @Override
    public int hashCode() { return Objects.hash(screeningid); }

    public Set<Reservation> getReservation() { return reservation; }

    public void setScreenings(Set<Reservation> reservation) { this.reservation = reservation; }

    public Integer getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(Integer screeningid) {
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

    public void setHall(int hall) {
        this.hall = hall;
    }
}

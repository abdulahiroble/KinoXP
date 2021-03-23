package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationid;

    @Column(name="ticketamount")
    private int ticketamount;

    @ManyToOne
    @JoinColumn(name = "screeningid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "screeningid")
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userid")
    private User user;

    public Reservation() {

    }

    public Reservation(int ticketamount, Screening screening) {
        this.ticketamount = ticketamount;
        this.screening = screening;
    }

    public Reservation(int ticketamount, User user) {
        this.ticketamount = ticketamount;
        this.user = user;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Screening getScreening() { return screening; }

    public void setScreening(Screening screening) { this.screening = screening; }

    public int getReservationid() { return reservationid; }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    public int getTicketamount() {
        return ticketamount;
    }

    public void setTicketamount(int ticketamount) {
        this.ticketamount = ticketamount;
    }
}

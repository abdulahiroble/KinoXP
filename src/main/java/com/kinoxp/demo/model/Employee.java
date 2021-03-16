package com.kinoxp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeid;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean movieeditor;
    private boolean reservationeditor;

    @Id
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMovieeditor() {
        return movieeditor;
    }

    public void setMovieeditor(boolean movieeditor) {
        this.movieeditor = movieeditor;
    }

    public boolean isReservationeditor() {
        return reservationeditor;
    }

    public void setReservationeditor(boolean reservationeditor) {
        this.reservationeditor = reservationeditor;
    }
}

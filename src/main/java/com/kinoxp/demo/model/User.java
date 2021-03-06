package com.kinoxp.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private String roles;
    private int phone;
    private int age;


    public User(String firstname, String lastname, String username, String email, String password, boolean active, String roles, int phone, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.phone = phone;
        this.age = age;
    }

    public User (String firstname, String lastname, String username, String email, String password, Boolean active, String roles, int phone, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.phone = phone;
        this.age = age;
    }

    @OneToMany
    @JoinColumn(name = "userid")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationid")
    private Set<Reservation> reservation = new HashSet<>();


    public User () {

    }



    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    public int getUserid() {
        return userid;
    }

    public Set<Reservation> getReservation() { return reservation; }

    public void setReservation(Set<Reservation> reservation) { this.reservation = reservation; }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return active;
    }

     public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhone() { return phone; }

    public void setPhone(int phone) { this.phone = phone; }

}

package com.kinoxp.demo.controller;

import com.kinoxp.demo.model.Reservation;
import com.kinoxp.demo.repositories.ReservationRepository;
import com.kinoxp.demo.repositories.ScreeningRepositoy;
import com.kinoxp.demo.repositories.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(value = "*")
public class ReservationRestController {

    ReservationRepository reservationRepository;

    UserRepository userRepository;

    ScreeningRepositoy screeningRepositoy;

    public ReservationRestController(ScreeningRepositoy screeningRepositoy, UserRepository userRepository,
            ReservationRepository reservationRepository) {
        this.screeningRepositoy = screeningRepositoy;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping(value = "/newreservation", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation postScreening(@RequestBody Reservation reservation) {

        System.out.println(reservationRepository);

        return reservationRepository.save(reservation);

    }

}

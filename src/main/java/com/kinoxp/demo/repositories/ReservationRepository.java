package com.kinoxp.demo.repositories;

import com.kinoxp.demo.model.Movie;
import com.kinoxp.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}

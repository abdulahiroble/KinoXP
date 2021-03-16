package com.kinoxp.demo.repositories;

import com.kinoxp.demo.model.Calendar;
import com.kinoxp.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
}

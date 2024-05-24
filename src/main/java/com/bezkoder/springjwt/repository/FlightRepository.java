package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Booking_flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Booking_flight, Long> {
    List<Booking_flight> findByAirline(String airline);
}

package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Booking_trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Booking_trip, Long> {
    List<Booking_trip> findByDestination(String destination);
}
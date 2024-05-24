package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Booking_passengers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerRepository extends JpaRepository<Booking_passengers, Long> {

}
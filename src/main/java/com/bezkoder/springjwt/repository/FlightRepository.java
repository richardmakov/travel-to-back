package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}

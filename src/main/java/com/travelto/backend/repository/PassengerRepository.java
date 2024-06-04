package com.travelto.backend.repository;

import com.travelto.backend.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
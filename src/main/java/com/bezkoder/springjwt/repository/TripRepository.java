package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDestination(String destination);
}
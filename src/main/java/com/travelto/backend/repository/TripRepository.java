package com.travelto.backend.repository;

import com.travelto.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDestination(String destination);
    boolean existsByDestination(String destination);
}
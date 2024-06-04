package com.travelto.backend.controllers;


import com.travelto.backend.service.TripService;
import com.travelto.backend.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/create")
    public void saveTrips(@RequestBody List<Trip> trips) {
        tripService.saveTrips(trips);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }

}
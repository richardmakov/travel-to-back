package com.bezkoder.springjwt.Service;


import com.bezkoder.springjwt.models.Trip;
import com.bezkoder.springjwt.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void saveTrips(List<Trip> trips) {
        tripRepository.saveAll(trips);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
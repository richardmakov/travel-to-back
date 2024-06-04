package com.travelto.backend.service;

import com.travelto.backend.models.Passenger;
import com.travelto.backend.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
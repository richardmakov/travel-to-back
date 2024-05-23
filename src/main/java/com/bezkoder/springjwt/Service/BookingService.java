package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.models.Booking;
import com.bezkoder.springjwt.models.Flight;
import com.bezkoder.springjwt.models.Trip;
import com.bezkoder.springjwt.repository.BookingRepository;
import com.bezkoder.springjwt.repository.FlightRepository;
import com.bezkoder.springjwt.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TripRepository tripRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Flight> getFlightsByAirline(String airline) {
        return flightRepository.findByAirline(airline);
    }

    public List<Trip> getTripsByDestination(String destination) {
        return tripRepository.findByDestination(destination);
    }

    @Transactional
    public Optional<Booking> updateBooking(Long bookingId, Booking newBookingData) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setBookingDate(newBookingData.getBookingDate());
            booking.setUser(newBookingData.getUser());
            return bookingRepository.save(booking);
        });
    }

    @Transactional
    public Optional<Flight> updateFlight(Long flightId, Flight newFlightData) {
        return flightRepository.findById(flightId).map(flight -> {
            flight.setFlightNumber(newFlightData.getFlightNumber());
            flight.setAirline(newFlightData.getAirline());
            flight.setPrice(newFlightData.getPrice());
            return flightRepository.save(flight);
        });
    }

    @Transactional
    public Optional<Trip> updateTrip(Long tripId, Trip newTripData) {
        return tripRepository.findById(tripId).map(trip -> {
            trip.setDestination(newTripData.getDestination());
            trip.setPrice(newTripData.getPrice());
            return tripRepository.save(trip);
        });
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }
}

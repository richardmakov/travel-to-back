package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.BookingService;
import com.bezkoder.springjwt.models.Booking;
import com.bezkoder.springjwt.models.Flight;
import com.bezkoder.springjwt.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @PostMapping("/flight")
    public Flight createFlight(@RequestBody Flight flight) {
        return bookingService.saveFlight(flight);
    }

    @PostMapping("/trip")
    public Trip createTrip(@RequestBody Trip trip) {
        return bookingService.saveTrip(trip);
    }

    @GetMapping("/flights/airline/{airline}")
    public List<Flight> getFlightsByAirline(@PathVariable String airline) {
        return bookingService.getFlightsByAirline(airline);
    }

    @GetMapping("/trips/destination/{destination}")
    public List<Trip> getTripsByDestination(@PathVariable String destination) {
        return bookingService.getTripsByDestination(destination);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking newBookingData) {
        return bookingService.updateBooking(bookingId, newBookingData)
                .map(updatedBooking -> ResponseEntity.ok().body(updatedBooking))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/flight/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @RequestBody Flight newFlightData) {
        return bookingService.updateFlight(flightId, newFlightData)
                .map(updatedFlight -> ResponseEntity.ok().body(updatedFlight))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/trip/{tripId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long tripId, @RequestBody Trip newTripData) {
        return bookingService.updateTrip(tripId, newTripData)
                .map(updatedTrip -> ResponseEntity.ok().body(updatedTrip))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/flight/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        bookingService.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/trip/{tripId}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long tripId) {
        bookingService.deleteTrip(tripId);
        return ResponseEntity.ok().build();
    }

}

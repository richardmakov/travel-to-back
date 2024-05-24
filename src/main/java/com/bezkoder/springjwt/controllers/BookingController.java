package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.BookingService;
import com.bezkoder.springjwt.models.*;
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
    public Booking_flight createFlight(@RequestBody Booking_flight bookingflight) {
        return bookingService.saveFlight(bookingflight);
    }

    @PostMapping("/trip")
    public Booking_trip createTrip(@RequestBody Booking_trip bookingtrip) {
        return bookingService.saveTrip(bookingtrip);
    }

    @PostMapping("/passenger")
    public Booking_passengers createPassenger(@RequestBody Booking_passengers bookingPassenger) {
        return bookingService.savePassenger(bookingPassenger);
    }

    @PostMapping("/payment")
    public Booking_payment createPayment(@RequestBody Booking_payment bookingPayment) {
        return bookingService.savePayment(bookingPayment);
    }

    @GetMapping("/flights/airline/{airline}")
    public List<Booking_flight> getFlightsByAirline(@PathVariable String airline) {
        return bookingService.getFlightsByAirline(airline);
    }

    @GetMapping("/trips/destination/{destination}")
    public List<Booking_trip> getTripsByDestination(@PathVariable String destination) {
        return bookingService.getTripsByDestination(destination);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking newBookingData) {
        return bookingService.updateBooking(bookingId, newBookingData)
                .map(updatedBooking -> ResponseEntity.ok().body(updatedBooking))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/flight/{flightId}")
    public ResponseEntity<Booking_flight> updateFlight(@PathVariable Long flightId, @RequestBody Booking_flight newBookingflightData) {
        return bookingService.updateFlight(flightId, newBookingflightData)
                .map(updatedBookingflight -> ResponseEntity.ok().body(updatedBookingflight))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/trip/{tripId}")
    public ResponseEntity<Booking_trip> updateTrip(@PathVariable Long tripId, @RequestBody Booking_trip newBookingtripData) {
        return bookingService.updateTrip(tripId, newBookingtripData)
                .map(updatedBookingtrip -> ResponseEntity.ok().body(updatedBookingtrip))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/passenger/{passengerId}")
    public ResponseEntity<Booking_passengers> updatePassenger(@PathVariable Long passengerId, @RequestBody Booking_passengers newBookingPassengerData) {
        return bookingService.updatePassenger(passengerId, newBookingPassengerData)
                .map(updatedBookingPassenger -> ResponseEntity.ok().body(updatedBookingPassenger))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/payment/{paymentId}")
    public ResponseEntity<Booking_payment> updatePayment(@PathVariable Long paymentId, @RequestBody Booking_payment newBookingPaymentData) {
        return bookingService.updatePayment(paymentId, newBookingPaymentData)
                .map(updatedBookingPayment -> ResponseEntity.ok().body(updatedBookingPayment))
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

    @DeleteMapping("/passenger/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long passengerId) {
        bookingService.deletePassenger(passengerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/payment/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        bookingService.deletePayment(paymentId);
        return ResponseEntity.ok().build();
    }

}


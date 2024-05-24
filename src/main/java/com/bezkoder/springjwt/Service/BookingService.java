package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.*;
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

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking_flight saveFlight(Booking_flight flight) {
        return flightRepository.save(flight);
    }

    public Booking_trip saveTrip(Booking_trip trip) {
        return tripRepository.save(trip);
    }

    public Booking_passengers savePassenger(Booking_passengers passenger) {
        return passengerRepository.save(passenger);
    }

    public Booking_payment savePayment(Booking_payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Booking_flight> updateFlight(Long flightId, Booking_flight newFlightData) {
        return flightRepository.findById(flightId).map(flight -> {
            flight.setFlightNumber(newFlightData.getFlightNumber());
            flight.setAirline(newFlightData.getAirline());
            flight.setPrice(newFlightData.getPrice());
            flight.setOrigin(newFlightData.getOrigin());
            flight.setDestination(newFlightData.getDestination());
            flight.setDepartureDate(newFlightData.getDepartureDate());
            flight.setArrivalDate(newFlightData.getArrivalDate());
            return flightRepository.save(flight);
        });
    }

    public Optional<Booking_trip> updateTrip(Long tripId, Booking_trip newTripData) {
        return tripRepository.findById(tripId).map(trip -> {
            trip.setDestination(newTripData.getDestination());
            trip.setPrice(newTripData.getPrice());
            return tripRepository.save(trip);
        });
    }

    public Optional<Booking_passengers> updatePassenger(Long passengerId, Booking_passengers newPassengerData) {
        return passengerRepository.findById(passengerId).map(passenger -> {
            passenger.setFirstname(newPassengerData.getFirstname());
            passenger.setLastname(newPassengerData.getLastname());
            passenger.setPassport(newPassengerData.getPassport());
            passenger.setDateOfBirth(newPassengerData.getDateOfBirth());
            return passengerRepository.save(passenger);
        });
    }

    public Optional<Booking_payment> updatePayment(Long paymentId, Booking_payment newPaymentData) {
        return paymentRepository.findById(paymentId).map(payment -> {
            payment.setCardtype(newPaymentData.getCardtype());
            payment.setCardholder(newPaymentData.getCardholder());
            payment.setCardnumber(newPaymentData.getCardnumber());
            payment.setExpiryDate(newPaymentData.getExpiryDate());
            return paymentRepository.save(payment);
        });
    }

    public Optional<Booking> updateBooking(Long bookingId, Booking newBookingData) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setBookingDate(newBookingData.getBookingDate());
            booking.setUser(newBookingData.getUser());
            return bookingRepository.save(booking);
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

    public void deletePassenger(Long passengerId) {
        passengerRepository.deleteById(passengerId);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public List<Booking_flight> getFlightsByAirline(String airline) {
        return flightRepository.findByAirline(airline);
    }

    public List<Booking_trip> getTripsByDestination(String destination) {
        return tripRepository.findByDestination(destination);
    }
}

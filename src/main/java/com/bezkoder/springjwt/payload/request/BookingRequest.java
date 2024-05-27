package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.Booking;
import com.bezkoder.springjwt.models.Passenger;

import java.util.List;

public class BookingRequest {
    private Booking booking;
    private List<Passenger> passengers;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
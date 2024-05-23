package com.bezkoder.springjwt.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Trip extends Booking {

    private String destination;
    private BigDecimal price;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

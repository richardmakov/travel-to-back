package com.bezkoder.springjwt.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String price_usd;
    private String price_eur;
    private String description;
    private String image;
    private String visit;
    private String departure_date;
    private String return_date;
    private String images_route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(String price_eur) {
        this.price_eur = price_eur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getImages_route() {
        return images_route;
    }

    public void setImages_route(String images_route) {
        this.images_route = images_route;
    }

    public Trip() {
    }

    public Trip(Long id, String destination, String image, String price_usd, String price_eur, String images_route, String description, String visit, String departure_date, String return_date) {
        this.id = id;
        this.destination = destination;
        this.image = image;
        this.price_usd = price_usd;
        this.price_eur = price_eur;
        this.images_route = images_route;
        this.description = description;
        this.visit = visit;
        this.departure_date = departure_date;
        this.return_date = return_date;
    }
}
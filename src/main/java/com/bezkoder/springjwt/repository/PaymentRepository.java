package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Booking_payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Booking_payment, Long> {
}
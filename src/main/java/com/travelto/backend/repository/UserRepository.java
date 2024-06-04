package com.travelto.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelto.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
  Boolean existsByIdCard(String IdCard);
  Boolean existsByPassport(String Passport);
}

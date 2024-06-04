package com.travelto.backend.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String firstname;

  @NotBlank
  @Size(min = 3, max = 20)
  private String lastname;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(min = 3, max = 50)
  private String country;

  @NotBlank
  @Size(min = 3, max = 20)
  private String phone;

  @NotBlank
  @Size(min = 6, max = 20)
  private String idCard;

  @NotBlank
  @Size(min = 3, max = 20)
  private String passport;

  @NotBlank
  @Size(min = 6, max = 20)
  private String date;


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}

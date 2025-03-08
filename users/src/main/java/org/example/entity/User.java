package org.example.entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User {
    private UUID userId;
    private String firstName;
    private String lastName;
    private Long phone;
    private String email;
    private LocalDate dateOfBirth;
    private String occupation;
    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionFinalDate;

    public User() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public LocalDate getSubscriptionFinalDate() {
        return subscriptionFinalDate;
    }

    public void setSubscriptionFinalDate(LocalDate subscriptionFinalDate) {
        this.subscriptionFinalDate = subscriptionFinalDate;
    }
}

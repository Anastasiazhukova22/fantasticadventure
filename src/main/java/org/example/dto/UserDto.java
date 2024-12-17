package org.example.dto;
import java.time.LocalDate;


public record UserDto(
        String firstName,
        String lastName,
        Integer phone,
        String email,
        LocalDate dateOfBirth,
        String occupation,
        LocalDate subscriptionStartDate,
        LocalDate subscriptionFinalDate) {
}

package org.example.dto;

import java.time.LocalDate;

public record UserModel(
        Integer userId,
        String firstName,
        String lastName,
        Integer phone,
        String email,
        LocalDate dateOfBirth,
        String occupation,
        LocalDate subscriptionStartDate,
        LocalDate subscriptionFinalDate
) {
}

package org.example.models;

import java.time.LocalDate;

public record UserModel(
        Integer userId,
        String firstName,
        String lastName,
        Long phone,
        String email,
        LocalDate dateOfBirth,
        String occupation,
        LocalDate subscriptionStartDate,
        LocalDate subscriptionFinalDate
) {
}


package org.example.dto;

import java.time.LocalDate;

public record UsersDto(
        String firstName,
        String lastName,
        Long phone,
        String email,
        LocalDate dateOfBirth,
        String occupation,
        LocalDate subscriptionStartDate,
        LocalDate subscriptionFinalDate) {
}

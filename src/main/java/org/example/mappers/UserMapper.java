package org.example.mappers;

import org.example.dto.UserDto;
import org.example.dto.UserModel;

import java.util.Random;

public class UserMapper {
    public static UserModel map (UserDto dto) {
        return new UserModel(new Random().nextInt(),
                dto.firstName(),
                dto.lastName(),
                dto.phone(),
                dto.email(),
                dto.dateOfBirth(),
                dto.occupation(),
                dto.subscriptionStartDate(),
                dto.subscriptionFinalDate());

    }
}

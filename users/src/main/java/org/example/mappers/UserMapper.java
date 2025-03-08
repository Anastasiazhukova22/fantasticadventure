package org.example.mappers;

import org.example.dto.UserDto;
import org.example.models.UserModel;

public class UserMapper {
    public static UserModel map(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(userDto.firstName());
        userModel.setLastName(userDto.lastName());
        userModel.setPhone(userDto.phone());
        userModel.setEmail(userDto.email());
        userModel.setDateOfBirth(userDto.dateOfBirth());
        userModel.setOccupation(userDto.occupation());
        userModel.setSubscriptionStartDate(userDto.subscriptionStartDate());
        userModel.setSubscriptionFinalDate(userDto.subscriptionFinalDate());
        return userModel;
    }
}
package org.example.mappers;

import org.example.dto.UsersDto;
import org.example.models.UsersModel;

public class UsersMapper {
    public static UsersModel map(UsersDto usersDto) {
        UsersModel usersModel = new UsersModel();
        usersModel.setFirstName(usersDto.firstName());
        usersModel.setLastName(usersDto.lastName());
        usersModel.setPhone(usersDto.phone());
        usersModel.setEmail(usersDto.email());
        usersModel.setDateOfBirth(usersDto.dateOfBirth());
        usersModel.setOccupation(usersDto.occupation());
        usersModel.setSubscriptionStartDate(usersDto.subscriptionStartDate());
        usersModel.setSubscriptionFinalDate(usersDto.subscriptionFinalDate());
        return usersModel;
    }
}
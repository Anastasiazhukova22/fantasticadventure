package org.example.controllers;

import org.example.dto.UserDto;
import org.example.dto.UserModel;
import org.example.mappers.UserMapper;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    List<UserModel> UserList = new ArrayList<>();


    @PostMapping("/user/add")
    public String addUser (@RequestBody UserDto userModel) {
        UserModel usersmodel = UserMapper.map(userModel);
        userList.add(userModel);

        System.out.println(userModel);
        return "На сайт добавлен новый пользователь с ID" + usersmodel.userId();
    }

    }
}



package org.example.controllers;

import org.example.dto.UserDto;
import org.example.dto.UserModel;
import org.example.mappers.UserMapper;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    List<UserModel> userList = new ArrayList<>();


    @PostMapping("/user/add")
    public String addUser (@RequestBody UserDto userModel) {
        UserModel usermodel = UserMapper.map(userModel);
        userList.add(usermodel);

        System.out.println(userModel);
        return "На сайт добавлен новый пользователь с ID" + usermodel.userId();
    }

    @GetMapping("/user/get")
    public UserModel getuser(Integer userId) {

        return userList.stream().filter(u ->userId.equals(u.userId())).findAny().get();
    }

}



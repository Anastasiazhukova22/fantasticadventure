package org.example.controllers;

import org.example.dto.UserDto;
import org.example.mappers.UserMapper;
import org.example.models.UserModel;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto) {
        UserModel userModel = UserMapper.map(userDto);
        userRepository.save(userModel);
        return "На сайт добавлен новый пользователь с ID " + userModel.getUserId();
    }

    @GetMapping("/get")
    public UserModel getUserId(@RequestParam Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
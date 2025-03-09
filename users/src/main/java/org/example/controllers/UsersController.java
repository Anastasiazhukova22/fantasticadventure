package org.example.controllers;

import org.example.dto.UsersDto;
import org.example.mappers.UsersMapper;
import org.example.models.UsersModel;
import org.example.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestBody UsersDto usersDto) {
        UsersModel usersModel = UsersMapper.map(usersDto);
        userRepository.save(usersModel);
        return "На сайт добавлен новый пользователь с ID " + usersModel.getUserId();
    }

    @GetMapping("/get")
    public UsersModel getUserId(@RequestParam Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
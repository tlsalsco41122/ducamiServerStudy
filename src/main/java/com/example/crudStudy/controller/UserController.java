package com.example.crudStudy.controller;

import com.example.crudStudy.dto.UserRequest;
import com.example.crudStudy.dto.UserResponse;
import com.example.crudStudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }
}

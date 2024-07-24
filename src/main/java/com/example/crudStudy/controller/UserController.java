package com.example.crudStudy.controller;

import com.example.crudStudy.dto.UserRequest;
import com.example.crudStudy.dto.UserResponse;
import com.example.crudStudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    // 유저 조회
    @GetMapping("/users/{id}")
    public UserResponse readUserById(@PathVariable Long id) {
        return userService.readUserById(id);
    }

    // 정보 수정
    @PatchMapping("/users/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    // 유저 삭제
    @DeleteMapping("/users/{id}") public Long deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}

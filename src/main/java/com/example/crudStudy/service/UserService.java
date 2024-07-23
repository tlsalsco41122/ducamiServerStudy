package com.example.crudStudy.service;

import com.example.crudStudy.dto.UserRequest;
import com.example.crudStudy.dto.UserResponse;
import com.example.crudStudy.entity.User;
import com.example.crudStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserResponse createUser(UserRequest request){
        User user = User.builder()
                .userId(request.getUserId())
                .userPw(request.getUserPw()).build();
        userRepository.save(user);
        return UserResponse.of(user);
    }
}

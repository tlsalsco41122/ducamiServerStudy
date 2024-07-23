package com.example.crudStudy.dto;

import com.example.crudStudy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String userId;
    private String userPw;


    public static UserResponse of(User user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .userPw(user.getUserPw()).build();
    }
}

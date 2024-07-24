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


    // 유저 생성
    public UserResponse createUser(UserRequest request){
        User user = User.builder()
                .userId(request.getUserId())
                .userPw(request.getUserPw()).build();
        userRepository.save(user);
        return UserResponse.of(user);
    }

    // 유저 조회
    public UserResponse readUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("아이디 없어유"));
        return UserResponse.of(user);
    }

    // 정보 수정
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("아이디 없으"));

        user.changeUserId(request.getUserId());
        user.changeUserPw(request.getUserPw());

        userRepository.save(user);
        return UserResponse.of(user);
    }

    // 유저 삭제
    public Long deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없다고"));
        userRepository.deleteById(id);
        return id;
    }
}

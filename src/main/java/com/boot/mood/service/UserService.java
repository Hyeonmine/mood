package com.boot.mood.service;

import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User saveUser(User user) {

       return userRepository.save(user);

    }

    public void confirmEmail(User user) {

        User confirmUser = userRepository.findByEmail(user.getEmail());
        if(confirmUser != null) {
            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
        }
    }

}

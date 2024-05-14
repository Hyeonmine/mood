package com.boot.mood.service;

import com.boot.mood.dto.UserDto;
import com.boot.mood.dto.UserFormDto;
import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(UserFormDto userDto){
        return userRepository.save(User.builder()
                .uid(userDto.getUid())
                .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .build());
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUid(String uid){
        return userRepository.findById(uid)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(String uid){
        userRepository.deleteById(uid);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }

}

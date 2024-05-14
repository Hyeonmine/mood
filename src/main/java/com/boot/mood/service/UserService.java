package com.boot.mood.service;

public class UserService {
import com.boot.mood.dto.UserDto;
import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(UserDto request){
        return userRepository.save(User.builder()
                .uid(request.getUid())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .nickname(request.getNickname())
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

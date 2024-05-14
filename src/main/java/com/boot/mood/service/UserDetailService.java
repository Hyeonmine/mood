package com.boot.mood.service;

import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uid){
        return userRepository.findById(uid)
                .orElseThrow(() -> new UsernameNotFoundException(uid));
    }
}

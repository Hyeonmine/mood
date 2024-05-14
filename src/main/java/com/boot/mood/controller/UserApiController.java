package com.boot.mood.controller;

import com.boot.mood.dto.UserDto;
import com.boot.mood.dto.UserResponse;
import com.boot.mood.entity.User;
import com.boot.mood.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(UserDto request) {
        userService.save(request);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody UserDto request) {
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> findAllDiaries() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/api/user/{uid}")
    // URL 경로에서 값 추출
    public ResponseEntity<UserResponse> findUserById(@PathVariable String uid) {
        User user = userService.findByUid(uid);
        return ResponseEntity.ok().body(new UserResponse(user));
    }

    @DeleteMapping("/api/user/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable String uid) {
        userService.delete(uid);
        return ResponseEntity.ok().build();
    }

}

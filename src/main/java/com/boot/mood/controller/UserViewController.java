package com.boot.mood.controller;

import com.boot.mood.dto.UserDto;
import com.boot.mood.dto.UserResponse;
import com.boot.mood.entity.User;
import com.boot.mood.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "login";
    }



    @GetMapping("/newUser")
    public String signup(){
        return "newUser";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();
        model.addAttribute("users", users); // 블로그 글 리스트 저장
        return "userList"; // articleList.html 라는 뷰 조회
    }

}

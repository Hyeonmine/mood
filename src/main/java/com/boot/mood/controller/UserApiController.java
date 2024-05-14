package com.boot.mood.controller;

import com.boot.mood.dto.UserFormDto;
import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import com.boot.mood.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping("/user")
    public String createAccount(UserFormDto userDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "account/accountCreateForm";
        }

        try{
            User user = User.createUser(userDto);
            userService.saveUser(user);
        }catch(IllegalStateException e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "account/accountCreateForm";
        }
        //form 에 에러메세지 설정
        //경로 변경
        return "account/accountCreateForm";
    }


    @GetMapping("/user/check")
    @ResponseBody
    public ResponseEntity<Map<String, String>> checkEmail(@RequestParam("email") String email) {
        Map<String, String> response = new HashMap<>();
        User confirmUser = userRepository.findByEmail(email);
        if (confirmUser != null) {
            response.put("message", "이미 존재하는 이메일입니다.");
        } else {
            response.put("message", "사용 가능한 이메일입니다.");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public String submitForm(@ModelAttribute User user) {
        // 사용자 등록 로직
        return "redirect:/account/accountCreateForm";
    }


}

package com.boot.mood.controller;

import com.boot.mood.dto.UserDto;
import com.boot.mood.dto.UserFormDto;
import com.boot.mood.dto.UserResponse;
import com.boot.mood.entity.User;
import com.boot.mood.repository.UserRepository;
import com.boot.mood.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @PostMapping("/user")
    public String createAccount(UserFormDto userDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "account/accountCreateForm";
        }

        try{
            User user = User.createUser(userDto,new BCryptPasswordEncoder());
            userService.save(userDto);
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
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

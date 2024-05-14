//package com.boot.mood.service;
//
//import com.boot.mood.dto.UserFormDto;
//import com.boot.mood.entity.User;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//@TestPropertySource(locations = "classpath:application-test.properties")
//
//class MoodApplicationTests {
//
//    @Autowired
//    UserService userService;
//
//
//    public User createUser(){
//        UserFormDto userDto = new UserFormDto();
//        userDto.setUid("12341234");
//        userDto.setEmail("test@naver.com");
//        userDto.setNickname("홍길동");
//        userDto.setPassword("1234");
//
//
//        return User.createUser(userDto);
//
//    }
//
//    @Test
//    @DisplayName("회원가입 테스트")
//    public void createUserTest() {
//        User user = createUser();
//        User savedUser = userService.saveUser(user);
//
//        assertEquals(user.getUid(), savedUser.getUid());
//        assertEquals(user.getEmail(), savedUser.getEmail());
//        assertEquals(user.getNickname(), savedUser.getNickname());
//        assertEquals(user.getPassword(), savedUser.getPassword());
//
//    }
//}
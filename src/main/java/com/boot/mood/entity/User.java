package com.boot.mood.entity;

import com.boot.mood.dto.UserFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="`user`")
public class User {

    @Id
    @Column(name = "uid")

    private String uid;

    private String email;

    private String nickname;

    private String password;




    //계정 생성, bycrptPassword 나중에 SecurityConfig에 빈으로 추가
    public static User createUser(UserFormDto userDto) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setEmail(userDto.getEmail());
        user.setNickname(userDto.getNickname());
        user.setPassword(userDto.getPassword());


        return user;
    }

}

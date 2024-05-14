package com.boot.mood.dto;

import com.boot.mood.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResponse {

    private String uid;
    private String email;
    private String nickname;

    public UserResponse(User user){
        this.uid = user.getUid();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}

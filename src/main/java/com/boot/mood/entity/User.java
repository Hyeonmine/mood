package com.boot.mood.entity;

import com.boot.mood.constant.Role;
import com.boot.mood.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString

@Table(name="user")
public class User implements UserDetails{

    @Id
    @Column(name="uid")
    private String uid;

    private String email;

    private String password;

    private String nickname;
  
//    @Enumerated(EnumType.STRING)
//    private Role role;


    public User createUser(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setEmail(userDto.getEmail());
        String password = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(password);
        user.setNickname(userDto.getNickname());
//        user.setRole(Role.USER);

        return user;
    }

    @Builder
    public User(String uid, String password, String email, String nickname, Role role) {
        this.uid = uid;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return uid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

package com.boot.mood.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name="uid")
    private String uid;

    private String email;

    private String password;

    private String nickname;


}

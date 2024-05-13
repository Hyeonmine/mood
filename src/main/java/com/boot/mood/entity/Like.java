package com.boot.mood.entity;

import com.boot.mood.entity.LikeId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`like`")
@Getter
@Setter
public class Like {

    @EmbeddedId
    private LikeId id;

    // 다른 필드들

    // 다른 getter와 setter 메서드들
}
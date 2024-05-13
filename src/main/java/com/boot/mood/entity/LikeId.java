package com.boot.mood.entity;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
@Embeddable
public class LikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bno", referencedColumnName = "bno")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;

    // 생성자, getter, setter 등을 작성합니다.

    // equals()와 hashCode() 메서드도 오버라이드해야 합니다.
}
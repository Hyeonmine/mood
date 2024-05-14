package com.boot.mood.entity;

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
public class HeartId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bno", referencedColumnName = "bno")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;


}
package com.boot.mood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="board")
public class Board extends BaseTimeEntity {

    @Id
    @Column(name = "bno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @ManyToOne
    @JoinColumn(name="uid")
    private User writer;

    private String title;

    private String content;

    private Long hit;

}

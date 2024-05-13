package com.boot.mood.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="hash")
public class Hash {

    @Id
    @Column(name="hno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hno;

    private String hash;

    @ManyToOne
    @JoinColumn(name="bno")
    private Board board;

}

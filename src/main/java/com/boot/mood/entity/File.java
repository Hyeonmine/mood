package com.boot.mood.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="file")
public class File {

    @Id
    @Column(name="fno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @ManyToOne
    @JoinColumn(name="bno")
    private Board board;

    private String fileUrl;

    private String fileName;

    private String fileOrigin;
}

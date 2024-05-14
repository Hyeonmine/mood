package com.boot.mood.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="file")
public class FileEntity {

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

    @Builder
    public FileEntity(Long fno, String fileUrl, String fileName, String fileOrigin) {
       this.fno = fno;
       this.fileUrl = fileUrl;
       this.fileName = fileName;
       this.fileOrigin = fileOrigin;
    }
}

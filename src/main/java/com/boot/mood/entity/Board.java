package com.boot.mood.entity;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.dto.UserFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name="board")
public class Board extends BaseTimeEntity{

    @Id
    @Column(name="bno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @ManyToOne(fetch = FetchType.LAZY)
    //(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private User writer;

    private String title;

    private String content;

    private Long hit;
    //클릭시 조회수 증가

    public static Board registBoard(BoardDto boardDto) {


        Board board = new Board();
        board.setBno(boardDto.getBno());
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setHit(3L);



        return board;
    }
}

//, UserFormDto userFormDto, List<MultipartFile> files
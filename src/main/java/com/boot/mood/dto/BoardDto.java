package com.boot.mood.dto;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardDto {

    private String title;
    private String content;
    private User writer;
    private Long hit;

    public BoardDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.hit = board.getHit();
    }


}

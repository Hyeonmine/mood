package com.boot.mood.dto;

import com.boot.mood.entity.BaseTimeEntity;
import com.boot.mood.entity.Board;
import com.boot.mood.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDto extends BaseTimeEntity {

    private Long bno;
    private User writer;
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String content;
    private Long hit;

//    private static ModelMapper modelMapper = new ModelMapper();

//    public Board createBoard(){
//        return modelMapper.map(this, Board.class);
//    }
//    public static BoardDto of(Board board){
//        return modelMapper.map(board, BoardDto.class);
//    }

    public BoardDto(Board board) {
        this.bno = board.getBno();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.hit = board.getHit();
    }

}

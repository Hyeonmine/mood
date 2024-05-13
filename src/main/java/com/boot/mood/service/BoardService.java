package com.boot.mood.service;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import com.boot.mood.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


//    public Long saveBoard(BoardDto boardDto) throws Exception{
//        Board board = boardDto.createBoard();
//        boardRepository.save(board);
//        return board.getBno();
//    }
    public List<Board> findAllBoard(){
        return boardRepository.findAll();
    }
}

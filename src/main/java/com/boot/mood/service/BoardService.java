package com.boot.mood.service;

import com.boot.mood.dto.SearchDto;
import com.boot.mood.entity.Board;
import com.boot.mood.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


//    public Long saveBoard(BoardDto boardDto) throws Exception{
//        Board board = boardDto.createBoard();
//        boardRepository.save(board);
//        return board.getBno();
//    }
    @Transactional(readOnly = true)
    public Page<Board> boardList( Pageable pageable){
        return boardRepository.findAll(pageable);
    }

//    @Transactional(readOnly = true)
//    public Page<Board> pageList(Pageable pageable){
//        return boardRepository.findAll(pageable);
//    }

//    @Transactional
//    public Page<Board> search(String keyword, Pageable pageable){
//        return  boardRepository.findByTitleContaining(keyword, pageable);
//    }

    @Transactional(readOnly = true)
    public Page<Board> getBoardPage(SearchDto searchDto, Pageable pageable){
        return boardRepository.getBoardPage(searchDto, pageable);
    }

}

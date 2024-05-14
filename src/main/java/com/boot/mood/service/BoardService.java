package com.boot.mood.service;

import com.boot.mood.entity.Board;
import com.boot.mood.repository.BoardRepository;
import com.boot.mood.repository.HeartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    final private BoardRepository boardRepository;


    // 모든 게시글 가져오기
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Board findById(Long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }


}

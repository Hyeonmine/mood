package com.boot.mood.service;

import com.boot.mood.dto.SearchDto;

import com.boot.mood.entity.Board;
import com.boot.mood.repository.BoardRepository;
import com.boot.mood.repository.HeartRepository;
import com.boot.mood.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    final private BoardRepository boardRepository;
    final private FileService fileService;
    @Transactional(readOnly = true)
    public Page<Board> getBoardPage(SearchDto searchDto, Pageable pageable){
        return boardRepository.getBoardPage(searchDto, pageable);
    }


    // 모든 게시글 가져오기
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }
    public Board registBoard (Board board, List < MultipartFile > files) throws IOException {

        for (MultipartFile multipartFile : files) {
                fileService.saveFile(multipartFile);
        }
        return boardRepository.save(board);

    }

 }


package com.boot.mood.service;


import com.boot.mood.entity.Board;
import com.boot.mood.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final FileService fileService;


    public Board registBoard(Board board, List<MultipartFile> files) throws IOException {

        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile);
        }
        return boardRepository.save(board);


    }

}

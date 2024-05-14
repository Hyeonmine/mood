package com.boot.mood.controller;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import com.boot.mood.entity.User;
import com.boot.mood.service.BoardService;
import com.boot.mood.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/board")
    public String registBoard(BoardDto boardDto, @RequestParam("uploadFiles") List<MultipartFile> files) throws IOException {


        Board board = Board.registBoard(boardDto);
        boardService.registBoard(board,files);



        return "/board/boardRegistForm";
    }


    @GetMapping("board/boardRegistForm")
    public String createAccount() {
        return "board/boardRegistForm";
    }


    //@GetMapping



}

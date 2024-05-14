package com.boot.mood.controller;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import com.boot.mood.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class ListController {

    private final BoardService boardService;

//    @GetMapping(value = "/board/new")
//    public String boardForm(Model model){
//        model.addAttribute("boardDto", new BoardDto());
//        return "board/board";
//    }

    @GetMapping(value = "/")
    public String boardList(Model model){
        List<Board> boards = boardService.findAllBoard();
        model.addAttribute("boards",boards);
        return "board/boardList";
    }

    @PostMapping(value = "/")
    public String boardList2(Model model){
        List<Board> boards = boardService.findAllBoard();
        model.addAttribute("boards",boards);
        return "board/boardList";
    }
}

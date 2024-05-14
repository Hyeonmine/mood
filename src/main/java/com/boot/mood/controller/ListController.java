package com.boot.mood.controller;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.dto.SearchDto;
import com.boot.mood.entity.Board;
import com.boot.mood.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = {"/{page}", "/"})
    public String boardList(SearchDto searchDto , Model model,@PathVariable("page") Optional<Integer> page) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
        Page<Board> boards = boardService.getBoardPage(searchDto, pageable);

        return "board/boardList";
    }

    @PostMapping(value = "/boardList")
    public String boardList2(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards",boards);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", boards.hasNext());
        model.addAttribute("hasPrev", boards.hasPrevious());
        model.addAttribute("searchDto", searchDto);
        model.addAttribute("maxPage", 5);
        return "board/boardList";
    }
}

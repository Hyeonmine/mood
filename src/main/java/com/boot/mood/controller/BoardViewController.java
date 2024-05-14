package com.boot.mood.controller;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import com.boot.mood.entity.Hash;
import com.boot.mood.entity.User;
import com.boot.mood.repository.HashRepository;
import com.boot.mood.service.BoardService;
import com.boot.mood.service.HashService;
import com.boot.mood.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardViewController {

    private final BoardService boardService;
    private final HashService hashService;
    private final HashRepository hashRepository;
    private final HeartService heartService;
    //private final UserService userService;

    @GetMapping("/board/{bno}")
    public String getBoard(@PathVariable Long bno, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 사용자 정보 조회
//        String username = authentication.getName();
//        User user = userService.findByUid(username);

        Board board = boardService.findById(bno);
        List<Hash> hashes = hashRepository.findByBoardBno(bno);
        User user = board.getWriter();
        boolean heart = heartService.findHeart(board, user);
//      Long boardView = board.getHit()+1;
//      model.addAttribute("uid", authentication.getName()); // 아이디
//      model.addAttribute("uname", user.getNickname()); // 닉네임
//      model.addAttribute("email", user.getEmail()); // 이메일
        model.addAttribute("board", new BoardDto(board));
//      model.addAttribute("boardView", boardView);
        model.addAttribute("heart", heart);

        model.addAttribute("hashes", hashes);
        return "board/detail_board";

    }

}

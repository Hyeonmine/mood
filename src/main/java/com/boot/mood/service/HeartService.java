package com.boot.mood.service;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.User;
import com.boot.mood.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HeartService {

    final private HeartRepository heartRepository;

    /** 글 좋아요 확인 **/
    public boolean findHeart(Board board, User user) {

        Long bno = board.getBno();
        String uid = user.getUid();
        return heartRepository.existsByIdBoardBnoAndIdUserUid(bno, uid);

    }

}

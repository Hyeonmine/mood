package com.boot.mood.repository;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.Heart;
import com.boot.mood.entity.HeartId;
import com.boot.mood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<Heart, HeartId> {

    boolean existsByIdBoardBnoAndIdUserUid(Long boardBno, String userUid);

}

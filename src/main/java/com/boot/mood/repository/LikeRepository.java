package com.boot.mood.repository;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.Like;
import com.boot.mood.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
}

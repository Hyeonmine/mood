package com.boot.mood.repository;

import org.springframework.stereotype.Repository;

@Repository
import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

}

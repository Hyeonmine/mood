package com.boot.mood.repository;

import org.springframework.stereotype.Repository;


import com.boot.mood.dto.BoardDto;
import com.boot.mood.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}

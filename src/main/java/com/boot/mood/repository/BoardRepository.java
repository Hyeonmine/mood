package com.boot.mood.repository;

import com.boot.mood.dto.BoardDto;
import com.boot.mood.dto.SearchDto;
import com.boot.mood.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> , QuerydslPredicateExecutor<Board>, BoardRepositoryCustom {


//    검색 기능
    @Query("select i from Board i where i.title like %:title%")
    List<Board> findByTitleContaining(@Param("title") String title);
}

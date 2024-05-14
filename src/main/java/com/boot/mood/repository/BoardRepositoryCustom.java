package com.boot.mood.repository;

import com.boot.mood.dto.SearchDto;
import com.boot.mood.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<Board> getBoardPage(SearchDto searchDto, Pageable pageable);
}

package com.boot.mood.repository;

import com.boot.mood.dto.SearchDto;
import com.boot.mood.entity.Board;
import com.boot.mood.entity.QBoard;
import com.boot.mood.entity.QUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;

public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{

    private JPAQueryFactory queryFactory;

    private final QBoard board = QBoard.board;
    private final QUser user = QUser.user;

    public BoardRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("title", searchBy)){
            return board.title.like("%" + searchQuery + "%");
        }else if(StringUtils.equals("writer", searchBy)){
            return user.uid.like("%" + searchQuery + "%");
        }
        return null;
    }

    @Override
    public Page<Board> getBoardPage(SearchDto searchDto, Pageable pageable) {

        List<Board> content = queryFactory
                .selectFrom(board)
                .where(searchByLike(searchDto.getSearchBy(),
                        searchDto.getSearchQuery()))
                .orderBy(board.bno.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(Wildcard.count)
                .from(board)
                .where(searchByLike(searchDto.getSearchBy(), searchDto.getSearchQuery()))
                .fetchOne();

        if(total == null){
            total = 0L;
        }
        return new PageImpl<>(content, pageable,total);
    }
}

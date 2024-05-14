package com.boot.mood.repository;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.Hash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashRepository extends JpaRepository<Hash, Long> {

    List<Hash> findByBoardBno(Long bno);

}

package com.boot.mood.repository;

import com.boot.mood.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}

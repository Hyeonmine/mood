package com.boot.mood.service;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.Hash;
import com.boot.mood.repository.HashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HashService {

    @Autowired
    private HashRepository hashRepository;

}


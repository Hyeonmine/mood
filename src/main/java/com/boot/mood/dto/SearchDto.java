package com.boot.mood.dto;

import com.boot.mood.entity.Board;
import com.boot.mood.entity.Hash;
import com.boot.mood.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page; //현재 페이지
    private int recordSize; //페이지당 출력할 데이터 개수
    private int pageSize; // 화면 하단에 출력할 페이지 사이즈
    private String searchBy; // 검색 키워드
    private String searchDataType; // 검색 유형
    private String searchQuery = "";

//    public SearchDto(){
//        this.page = 1;
//        this.recordSize = 10;
//        this.pageSize = 10;
//    }
//    public int getOffset(){
//        return (page - 1) * recordSize;
//    }
}

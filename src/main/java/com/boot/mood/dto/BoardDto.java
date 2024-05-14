package com.boot.mood.dto;

import com.boot.mood.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private Long bno;

    private String title;

    private String content;

    private Long hit;
}

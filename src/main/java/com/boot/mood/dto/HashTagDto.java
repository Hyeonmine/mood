package com.boot.mood.dto;

import com.boot.mood.entity.Hash;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class HashTagDto {

    private Long hno;
    private Long bno;
    private String hash;

    public HashTagDto(Hash hash) {
        this.hno = hash.getHno();
        this.hash = hash.getHash();
    }

}

package com.boot.mood.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "heart")
@Getter
@Setter
public class Heart {

    @EmbeddedId
    private HeartId id;

}
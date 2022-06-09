package com.example.demott.dto;

import com.example.demott.entity.statusEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class dtoUser {
    private Integer id;
    private String name;
    private Time modifiedDate;
    private statusEntity statusentity;
}

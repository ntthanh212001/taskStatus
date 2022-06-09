package com.example.demott.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class statusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private Integer priority;



}

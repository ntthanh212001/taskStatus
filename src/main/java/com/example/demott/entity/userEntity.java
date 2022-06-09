package com.example.demott.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Time modifiedDate ;

    @ManyToOne
    @JoinColumn(name = "id_status")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private statusEntity statusentity;

}













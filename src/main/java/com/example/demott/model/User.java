package com.example.demott.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User<T> {
//    private String message;
//    private boolean status;
//    private Object data;
//    private int activePage;
//    private int totalPage;
    private int recordCount;
    T response;
}

package com.example.demott.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class dataStatus {
    private boolean status;
    private String message;
//    private Object dataStatus;
    private Object data;

    public dataStatus(boolean status,String message ){
        this.status = status;
        this.message = message;
    }

    public dataStatus(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}

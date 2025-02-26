package com.sh.restapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String name;
    private Integer number; //json에서는 Integer타입 지향(primitive는 null값이 안 들어가니)
    private String category;
}

package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // return type 에 따라 달라진다
    @PostMapping("/post")
    public String post(@RequestBody BookRequest bookRequest) {
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    // 사용자의 이름, 전화번호, 이메일을 받는 POST METHOD
    @PostMapping("/user")
    public void User (@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
    }

}

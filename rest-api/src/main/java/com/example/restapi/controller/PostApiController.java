package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.ManRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(@RequestBody BookRequest request){
        System.out.println("request = " + request);

        return request.toString();
    }


    // TODO RequestBody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method를 만들라
    /**
     * 사람의 이름, 전화번호, 이메일을 반환하는 함수
     * @param manRequest
     * @return String
     */
    @PostMapping("/postman")
    public String man(@RequestBody ManRequest manRequest){
        System.out.println("manRequest = " + manRequest);
        return manRequest.toString();
    }


}

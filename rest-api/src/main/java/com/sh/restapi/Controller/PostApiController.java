package com.sh.restapi.Controller;


import com.sh.restapi.model.BookRequest;
import com.sh.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    //TODO RequestNody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method를 만들어주세요
    @PostMapping("/todo")
    public UserRequest todo(@RequestBody UserRequest userRequest){
        System.out.println(userRequest);
        return userRequest;
    }
}

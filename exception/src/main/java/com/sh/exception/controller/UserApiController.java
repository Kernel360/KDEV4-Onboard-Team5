package com.sh.exception.controller;


import com.sh.exception.model.Api;
import com.sh.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("유관순")
                    .build()
    );

    @GetMapping("id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        //GlobalException test를 위한 error
        if(true){
            throw new RuntimeException("message");
        }

        var user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId)
                )
                .findFirst()
                .get(); //값이 없다면 null

        Api<UserResponse> response = Api.<UserResponse>builder()
                .data(user)
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .build();

        return response;
    }
}

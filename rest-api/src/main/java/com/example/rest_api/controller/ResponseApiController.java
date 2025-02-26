package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

//    @GetMapping("")
//    public UserRequest user() {
//        var user = new UserRequest();
//        user.setUserName("홍길동");
//        user.setUserAge(20);
//        user.setEmail("hong@example.com");
//
//        log.info("user: {}", user);
//
//        return user;
//    }

//    @GetMapping("")
//    public String user() {
//        var user = new UserRequest();
//        user.setUserName("홍길동");
//        user.setUserAge(20);
//        user.setEmail("hong@example.com");
//
//        log.info("user: {}", user);
//
//        return user.toString();
//    }

    @GetMapping("")
    //@RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<UserRequest> user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("hong@example.com");

        log.info("user: {}", user);

        var res = ResponseEntity
            .status(HttpStatus.OK)
            .header("x-custom", "hi")
            .body(user);

        return res;
    }
}

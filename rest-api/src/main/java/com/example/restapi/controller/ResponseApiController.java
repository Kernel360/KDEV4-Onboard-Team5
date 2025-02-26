package com.example.restapi.controller;

import com.example.restapi.model.ManRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Controller
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
//    @ResponseBody
    public ManRequest user(){

        var user = new ManRequest();
        user.setName("홍길동");
        user.setEmail("hong.@gmail.com");
        user.setPhoneNum("11");

        log.info("user : {}", user);

        var response = ResponseEntity.status(HttpStatus.BAD_REQUEST).header("x-custom","hi").body(user);

        return user;
    }
}

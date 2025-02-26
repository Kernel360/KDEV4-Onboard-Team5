package com.sh.exception.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path="")
    public void hello(){
        //throw new RuntimeException("run time exception call");

        // 존재하지 않는 인덱스 값 받는 에러
        var list = List.of("hello");
        var element = list.get(1);
        log.info("element: {}", element);



    }
}

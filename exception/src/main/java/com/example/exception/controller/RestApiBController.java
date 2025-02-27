package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    // localhost:8080/api/b/hello
    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number for exception");
    }

//    // 컨트롤러 내부에 ExceptionHandler을 만들면 ControllerAdvice가 아닌 해당 컨트롤러에서 담당
//    @ExceptionHandler(value = { NumberFormatException.class})
//    public ResponseEntity numberFormatException (NumberFormatException e){
//        log.error("RestApiBController", e);
//
//        return ResponseEntity.ok().build();
//    }

}

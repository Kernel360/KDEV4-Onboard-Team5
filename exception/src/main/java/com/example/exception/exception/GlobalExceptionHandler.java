package com.example.exception.exception;

import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
/*
ExceptionHandler가 여러개인 경우, 순서를 정해야 한다. 이때 @Order의 value 값을 통해
순서를 정할 수 있다.
value가 높으면 나중에 적용되고
value가 낮으면 먼저 적용된다.
default = Integer.MAX_VALUE
 */
@Order(value = Integer.MAX_VALUE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(Exception e){
        log.error("",e);

        var response = Api.builder().resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.name()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
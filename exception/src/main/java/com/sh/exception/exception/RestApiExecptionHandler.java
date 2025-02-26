package com.sh.exception.exception;


import com.sh.exception.controller.RestApiBController;
import com.sh.exception.controller.RestApiController;
import com.sh.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
@Order(1)
public class RestApiExecptionHandler {

//    @ExceptionHandler(value = { Exception.class })
//    public ResponseEntity exception(
//            Exception e
//    ){
//        log.error("RestApiExceptionHandler",e);
//
//        return ResponseEntity.status(200).build();
//    }

    //예상하지 못한 모든 예외 처리
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error("",e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.IM_USED.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(value = { IndexOutOfBoundsException.class })
    public ResponseEntity outOfBounds(Exception e) {
        log.error("IndexOutOfBoundsException",e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> NoSuchElement(
            NoSuchElementException e
    ){
        log.error("",e);

        var response = Api.builder()
                .resultCode(HttpStatus.NOT_FOUND.name())
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

}

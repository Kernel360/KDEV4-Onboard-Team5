package com.example.restapi;

import com.example.restapi.model.ManRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiApplicationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        var user = new ManRequest("홍길동","010-1234-1234","dldjdtjr@gmail.com",true);
        System.out.println("user = " + user);
        //        user.setName("홍길동");
//        user.setPhoneNum("010-1234-1234");
//        user.setEmail("dldjdtjr@gmail.com");
//        user.setIsKorean(true);

        var json = objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);

//        var dto = objectMapper.readValue(json, ManRequest.class);
//        System.out.println("dto = " + dto);
    }



}
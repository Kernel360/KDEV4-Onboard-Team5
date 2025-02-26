package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    @GetMapping("/echo/{message}/{bool}/{n}")
    public String echo(@PathVariable(name = "message") String msg, @PathVariable(name = "bool") boolean tf, @PathVariable(name = "n") int paramNum){
        System.out.println("echo message : " + msg);

        // TODO 대문자로 변경해서 RETURN
        msg = msg.toUpperCase();

        // String 타입의 변수 외에 다른 타입 받아보기
        String boolMsg = Boolean.toString(tf);

        // boolean, integer
        String intMsg = Integer.toString(paramNum);

        return msg + " " + boolMsg + " " + intMsg;
    }
}

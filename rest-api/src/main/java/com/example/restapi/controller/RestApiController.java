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

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable(name = "message") String msg){
        System.out.println("echo message : " + msg);

        // TODO 대문자로 변경해서 RETURN
        msg = msg.toUpperCase();

        return msg;
    }
}

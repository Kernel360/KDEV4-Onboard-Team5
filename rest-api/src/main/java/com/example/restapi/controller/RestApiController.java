package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    @GetMapping("/echo/{message}/is-man/{isMan}/age/{age}")
    public String echo(@PathVariable(name = "message") String msg, @PathVariable(name = "isMan") boolean tf, @PathVariable(name = "age") int paramNum) {
        System.out.println("echo message : " + msg);

        // TODO 대문자로 변경해서 RETURN
        msg = msg.toUpperCase();

        // String 타입의 변수 외에 다른 타입 받아보기
        String boolMsg = Boolean.toString(tf);

        // boolean, integer
        String intMsg = Integer.toString(paramNum);

        return msg + " " + boolMsg + " " + intMsg;
    }

    //http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(@RequestParam String category, @RequestParam String issuedYear, @RequestParam(name = "issued-month") String issuedMonth, @RequestParam(name = "issued_day") String issuedDay) {
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(BookQueryParam bookQueryParam) {
        System.out.println("bookQueryParam = " + bookQueryParam);
    }

    // TODO Parameter 2가지 받습니다. int 형태로 받아서 두 수의 덧셉, 곱셈
    @GetMapping(path="/calc")
    public String calcQueryParam(@RequestParam int num1, @RequestParam int num2, @RequestParam boolean isMul) {
        return isMul?Integer.toString(num1*num2):Integer.toString(num1+num2);
    }

}

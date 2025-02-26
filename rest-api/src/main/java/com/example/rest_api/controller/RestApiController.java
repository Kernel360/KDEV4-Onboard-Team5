package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "<html><body><h1>Hello Spring Boot</h1></body></html>";
    }

    // Path Variable 실습
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable String message
                        // Path Variable 일치하는 변수명을 name 으로 지정 가능
                        // @PathVariable(name="message") Sting msg
        , @PathVariable int age,
        @PathVariable boolean isMan
    ) {
        System.out.println("echo message: " + message);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);

        // window 한글 깨지는 현상 해결 (setting > encoding 설정 변경)
        // 웹은 기존으로 UTF-8 (3byte) , window MS949 사용 (2byte)

        // 대문자로 변환해서 RETURN
        return message.toUpperCase();
    }

    // Query Parameter 실습
    @GetMapping("/book")
    public void queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name = "issued-month") String issuedMonth,
        @RequestParam String issuedDay
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    // 객체를 통해서 파싱
    // 변수의 내용이 많을 때 효율적으로 파싱
    @GetMapping("/book2")
    public void queryParamDTO(
        BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
    }

    // Parameter int 2가지 받아서 두 수의 덧셈, 곱셈 (boolean type 추가)
    @GetMapping("/calculate")
    public void calculate(
        @RequestParam int num1,
        @RequestParam int num2,
        @RequestParam boolean isAdd
    ) {
        int result;

        if (isAdd) {
            result = num1 + num2;
            System.out.println("Add : " + result);
        } else {
            result = num1 * num2;
            System.out.println("Multiplication : " + result);
        }
    }

}

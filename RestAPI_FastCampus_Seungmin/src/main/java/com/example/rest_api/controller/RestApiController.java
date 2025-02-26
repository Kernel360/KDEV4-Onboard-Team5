package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path="/hello")
    public String Hello() {
        var html = "<html><body><h1> Hello Spring Boot</h1> </body></html>";
        return html;
    }

    // http://localhost:8080

    @GetMapping(path="/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
//          @PathVariable() String message
          @PathVariable(name="message") String msg,
          @PathVariable int age,
          @PathVariable boolean isMan
    ) {
//        System.out.println("echo message : " + message);
        System.out.println("echo message : " + msg);
        System.out.println("echo message : " + age);
        System.out.println("echo message : " + isMan);

//        return message;
        return msg +" "+ age +" "+ isMan;

//      대문자로 변환해서 Return
//        return msg.toUpperCase();
//        String 타입의 변수 외에 다른 타입 받아보기
//        return message;
    }

//    @GetMapping(path="/myPage/{myAge}")
//    public Integer ageMsg(
//            @PathVariable(name="myAge") Integer age
//    ) {
//        return age;
//    }
//
//    @GetMapping(path="/carBuy/{check}")
//    public boolean isCar(
//            @PathVariable(name="check") boolean car
//    ) {
//        System.out.println(car);
//        return car;
//    }

        // http://localhost:8080/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
        @GetMapping(path="/book")
        public void queryParam(
                @RequestParam String category,
                @RequestParam String issuedYear,
                @RequestParam(name="issued-month") String issuedMonth,
                @RequestParam(name="issued_day") String issuedDay) {
            System.out.println(category);
            System.out.println(issuedYear);
            System.out.println(issuedMonth);
            System.out.println(issuedDay);
    }

    @GetMapping(path="/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam) {
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받습니다. int 형태로 받아서 두 수의 곱셈, 덧셈
    @GetMapping(path="/book3")
    public String calcNum(
            @RequestParam int num1,
            @RequestParam int num2
    ) {
        System.out.println("numSum : " + (num1 + num2));
        System.out.println("numMultiple : " + (num1 * num2));
        return "numSum : " + (num1 + num2) + " numMultiple : " + (num1 * num2);
    }

    // TODO String 타입 Boolean 타입도 받아보기
    @GetMapping(path="/marriage")
    public String b(@RequestParam boolean isMarried) {
        return "isBool : "+isMarried;
    }

    @DeleteMapping(path={
            "/user/{userName}/delete"
            ,"/user/{userName}/del"})
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name : {}", userName);


    }

}

package com.sh.restapi.Controller;


import com.sh.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {


    //가장 기본적인 api 요청시 문자열을 반환
    @GetMapping(path="/hello")
    public String hello(){

        var html ="<html><body><h1>Hello World!</h1></body></html>";
        //return "Hello Spring Boot";
        return html;
    }


    //path variable 받기
    @GetMapping(path="/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable String message,
            @PathVariable int age,
            @PathVariable boolean isMan
            //@PathVariable boolean message
            //@PathVariable(name = "message") String msg
            //@PathVariable String message
    )
    {
        System.out.println("echo message: "+message);
        System.out.println("echo age: "+age);
        System.out.println("echo isMan: "+isMan);

        //TODO 대문자로 변환해서 RETURN
        //return msg.toUpperCase();

        // String 타입의 변수 외에 다른 타입 받아보기
        //boolean, integer
        return message.toUpperCase();

    }

    //QueryParameter 받기
    //https://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path="/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day" )String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);

    }

    //http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path="/book2")
    public void queryParam2(
                BookQueryParam bookQueryParam
            ){
        System.out.println(bookQueryParam);

    }

    //TODO Parameter 2가지 받기, int 형태로 받아서 두 수의 덧셈, 곱셈
    //http://localhost:8080/api/todo?a=1&b=2
    @GetMapping(path="/todo")
    public String todo(
            @RequestParam int a,
            @RequestParam int b
    ){
        return "addition: "+a+" substraction: "+b;
    }

    //TODO String 타입 boolean 타입도 받아보기
    //http://localhost:8080/api/todo2?a=1&bool=true
    @GetMapping(path="/todo2")
    public void todo2(
            @RequestParam int a,
            @RequestParam boolean bool
    ){
        System.out.println(a);
        System.out.println(bool);
    }

    @DeleteMapping(path={
            "/user/{userName}/delete",
            "/user/{userName}/del"
    })
    public void delete(
            @PathVariable String userName
    ){
        log.info(userName);
    }


}

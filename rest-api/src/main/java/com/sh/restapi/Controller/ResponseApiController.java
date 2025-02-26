package com.sh.restapi.Controller;


import com.sh.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

//    @GetMapping("")
//    //@ResponseBody
//    //@RequestMapping(path="", method = RequestMethod.GET)
//    public ResponseEntity user(){
//        var user = new UserRequest();
//        user.setUserAge(10);
//        user.setUserName("test");
//        user.setEmail("hong@gmail.com");
//
//        log.info("user: {}", user);
//
//        var response = ResponseEntity
//                .status(HttpStatus.BAD_GATEWAY)
//                .header("x-custom","hi")
//                .body(user);
//
//        return response;
//    }
}

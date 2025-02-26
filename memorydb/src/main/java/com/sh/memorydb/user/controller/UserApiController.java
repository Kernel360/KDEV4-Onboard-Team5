package com.sh.memorydb.user.controller;


import com.sh.memorydb.user.model.UserEntity;
import com.sh.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    //원래 이렇게 entity를 controller에서 받으면 안됨
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> getAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable Long id){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> getScore(
            @RequestParam int score
    ){
        return userService.findByScore(score);
    }
}

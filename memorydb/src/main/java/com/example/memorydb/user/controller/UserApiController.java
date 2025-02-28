package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    // delete
    @DeleteMapping("id/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }


    // findby id -> path variable
    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable Long id){
        return userService.findById(id).get();
    }

    // 70점 이상의 사용자의 정보를 찾아주는 메소드
    @GetMapping("/over/{score}")
    public List<UserEntity> findAllByScore(@PathVariable Long score){
        return userService.findAllByScore(score);
    }
}

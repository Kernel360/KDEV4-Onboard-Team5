package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    // CREATE, UPDATE
    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity user) {
        return userService.save(user);
    }

    // READ
    @GetMapping("/all")
    public List<UserEntity>  findAll() {
        return userService.findAll();
    }

    // DELETE
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    // READ (id, path variable)
    @GetMapping("/{id}")
    public UserEntity findOne(@PathVariable Long id) {
        var response = userService.findById(id);
        return response.get();
    }

    // READ (70점 이상)
    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score) {
        return userService.filterScore(score);
    }

}

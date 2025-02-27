package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    // 70점 이상인 user 찾기
    public List<UserEntity> findAllScoreGreaterThan(int score) {
        return this.findAll().stream()
            .filter(
                it -> {
                    return it.getScore() >= score;
                }
            ).collect(Collectors.toList());
    }
}

package com.example.memorydb.entity;

// database 고유한 값
public interface PrimaryKey {
    void setId(Long id);
    Long getId();
}

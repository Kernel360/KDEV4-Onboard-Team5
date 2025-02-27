package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {

    // CREATE, UPDATE
    T save(T data);

    // READ
    Optional<T> findById(ID id);
    List<T> findAll();

    // DELETE
    void delete(ID id);
}

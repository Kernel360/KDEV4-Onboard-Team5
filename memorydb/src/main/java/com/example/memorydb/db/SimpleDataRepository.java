package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    // 자신만의 저장 공간
    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // CREATE, UPDATE
    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("Data is null");
        }

        // db 이미 존재하는가?
        var prevData = dataList.stream()
            .filter(it -> {
                return it.getId().equals(data.getId());
            })
            .findFirst();

        if (prevData.isPresent()) {
            // 기존 데이터 있는 경우 (UPDATE)
            // Optional 이기 떄문에 삭제가 되지 않아 .get() 붙여주기
            dataList.remove(prevData.get()); // 기존 data 삭제
            dataList.add(data); // 빈 공간에 다시 집어넣기 (id는 유지)
        } else {
            // 없는 경우 (CREATE)
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }

    // READ
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
            .filter(it -> {
                return (it.getId().equals(id));
            })
            .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
            .sorted(sort)
            .collect(Collectors.toList());
    }

    // DELETE
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
            .filter(it -> {
                return (it.getId().equals(id));
            })
            .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }

}

package com.example.memorydb.book.controller;

import com.example.memorydb.book.entity.BookEntity;
import com.example.memorydb.book.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(@RequestBody BookEntity book) {
        return bookService.create(book);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }
}

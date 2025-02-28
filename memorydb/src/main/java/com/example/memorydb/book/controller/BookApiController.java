package com.example.memorydb.book.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookApiController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public BookEntity create(@RequestBody BookEntity book) {
        return bookService.create(book);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    // delete
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

    // find one
    @GetMapping("/id/{id}")
    public BookEntity findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}

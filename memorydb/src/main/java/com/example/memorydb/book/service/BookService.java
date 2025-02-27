package com.example.memorydb.book.service;

import com.example.memorydb.book.entity.BookEntity;
import com.example.memorydb.book.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    // 생성자 method 에 bookRepository 주입
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE, UPDATE
    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    // READ - all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // DELETE
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    // READ - one
    public Optional<BookEntity> findOne(Long id) {
        return bookRepository.findById(id);
    }
}

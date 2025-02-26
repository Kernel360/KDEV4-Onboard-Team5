package com.sh.memorydb.book.db.repository;

import com.sh.memorydb.book.db.entity.BookEntity;
import com.sh.memorydb.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
}

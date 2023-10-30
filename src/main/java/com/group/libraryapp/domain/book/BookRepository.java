package com.group.libraryapp.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 1. 책 정보를 가져온다. (from BookService)
    Optional<Book> findByName(String name);
}

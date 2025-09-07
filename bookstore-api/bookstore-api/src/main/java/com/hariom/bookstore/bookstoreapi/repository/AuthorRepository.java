package com.hariom.bookstore.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hariom.bookstore.bookstoreapi.model.Author;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameIgnoreCase(String name);
}

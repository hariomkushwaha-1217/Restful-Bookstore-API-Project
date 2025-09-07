package com.hariom.bookstore.bookstoreapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hariom.bookstore.bookstoreapi.repository.BookRepository;
import com.hariom.bookstore.bookstoreapi.repository.AuthorRepository;
import com.hariom.bookstore.bookstoreapi.model.Book;
import com.hariom.bookstore.bookstoreapi.model.Author;
import com.hariom.bookstore.bookstoreapi.dto.BookRequest;
import com.hariom.bookstore.bookstoreapi.spec.BookSpecifications;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book create(BookRequest req) {
        Author author = authorRepository.findById(req.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book b = new Book();
        b.setTitle(req.getTitle());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        b.setPublishedDate(req.getPublishedDate());
        b.setAuthor(author);
        return bookRepository.save(b);
    }

    public Book update(Long id, BookRequest req) {
        Book b = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findById(req.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        b.setTitle(req.getTitle());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        b.setPublishedDate(req.getPublishedDate());
        b.setAuthor(author);
        return bookRepository.save(b);
    }

    public void delete(Long id) { bookRepository.deleteById(id); }

    public Book get(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Page<Book> search(String titleContains,
                             String authorName,
                             BigDecimal minPrice,
                             BigDecimal maxPrice,
                             LocalDate publishedAfter,
                             LocalDate publishedBefore,
                             Pageable pageable) {
        Specification<Book> spec = Specification
                .where(BookSpecifications.titleContains(titleContains))
                .and(BookSpecifications.authorNameEquals(authorName))
                .and(BookSpecifications.priceBetween(minPrice, maxPrice))
                .and(BookSpecifications.publishedBetween(publishedAfter, publishedBefore));
        return bookRepository.findAll(spec, pageable);
    }
}

package com.hariom.bookstore.bookstoreapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hariom.bookstore.bookstoreapi.service.BookService;
import com.hariom.bookstore.bookstoreapi.model.Book;
import com.hariom.bookstore.bookstoreapi.dto.BookRequest;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { 
    	this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody BookRequest req) {
    	return bookService.create(req); 
    }

    @PutMapping("/<built-in function id>")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookRequest req) {
    	return bookService.update(id, req);
    }

    @DeleteMapping("/<built-in function id>")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { 
    	bookService.delete(id);
    }

    @GetMapping("/<built-in function id>")
    public Book get(@PathVariable Long id) { 
    	return bookService.get(id); 
    }

    @GetMapping
    public Page<Book> search(@RequestParam(required = false) String titleContains,
                             @RequestParam(required = false) String authorName,
                             @RequestParam(required = false) BigDecimal minPrice,
                             @RequestParam(required = false) BigDecimal maxPrice,
                             @RequestParam(required = false) LocalDate publishedAfter,
                             @RequestParam(required = false) LocalDate publishedBefore,
                             @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return bookService.search(titleContains, authorName, minPrice, maxPrice, publishedAfter, publishedBefore, pageable);
    }
}

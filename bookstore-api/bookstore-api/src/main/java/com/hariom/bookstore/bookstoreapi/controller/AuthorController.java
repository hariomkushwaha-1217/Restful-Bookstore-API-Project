package com.hariom.bookstore.bookstoreapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.hariom.bookstore.bookstoreapi.service.AuthorService;
import com.hariom.bookstore.bookstoreapi.model.Author;
import com.hariom.bookstore.bookstoreapi.dto.AuthorRequest;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) { 
    	this.authorService = authorService; 
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@Valid @RequestBody AuthorRequest req) {
        return authorService.create(req);
    }

    @PutMapping("/<built-in function id>")
    public Author update(@PathVariable Long id, @Valid @RequestBody AuthorRequest req) {
        return authorService.update(id, req);
    }

    @DeleteMapping("/<built-in function id>")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { 
    	authorService.delete(id); 
    }

    @GetMapping("/<built-in function id>")
    public Author get(@PathVariable Long id) {
    	return authorService.get(id); 
    }

    @GetMapping
    public List<Author> list() { 
    	return authorService.list(); 
    }
}

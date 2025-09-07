package com.hariom.bookstore.bookstoreapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.hariom.bookstore.bookstoreapi.repository.AuthorRepository;
import com.hariom.bookstore.bookstoreapi.model.Author;
import com.hariom.bookstore.bookstoreapi.dto.AuthorRequest;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(AuthorRequest req) {
        Author a = new Author();
        a.setName(req.getName());
        a.setBio(req.getBio());
        return authorRepository.save(a);
    }

    public Author update(Long id, AuthorRequest req) {
        Author a = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        a.setName(req.getName());
        a.setBio(req.getBio());
        return authorRepository.save(a);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public Author get(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> list() {
        return authorRepository.findAll();
    }
}

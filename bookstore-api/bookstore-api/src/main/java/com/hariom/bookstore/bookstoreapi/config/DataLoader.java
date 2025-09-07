package com.hariom.bookstore.bookstoreapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hariom.bookstore.bookstoreapi.repository.AuthorRepository;
import com.hariom.bookstore.bookstoreapi.repository.BookRepository;
import com.hariom.bookstore.bookstoreapi.model.Author;
import com.hariom.bookstore.bookstoreapi.model.Book;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            if (authorRepository.count() == 0) {
                Author a1 = new Author();
                a1.setName("Robert Martin"); 
                a1.setBio("Uncle Bob");
                
                Author a2 = new Author(); 
                a2.setName("Joshua Bloch"); 
                a2.setBio("Java expert");
                authorRepository.save(a1);
                authorRepository.save(a2);

                Book b1 = new Book();
                b1.setTitle("Clean Code");
                b1.setIsbn("9780132350884");
                b1.setPrice(new BigDecimal("450.00"));
                b1.setPublishedDate(LocalDate.of(2008, 8, 1));
                b1.setAuthor(a1);
                
                Book b2 = new Book();
                b2.setTitle("Effective Java");
                b2.setIsbn("9780134685991");
                b2.setPrice(new BigDecimal("550.00"));
                b2.setPublishedDate(LocalDate.of(2018, 1, 6));
                
                b2.setAuthor(a2);
                bookRepository.save(b1);
                bookRepository.save(b2);
            }
        };
    }
}

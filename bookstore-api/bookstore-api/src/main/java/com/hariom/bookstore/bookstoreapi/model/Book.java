package com.hariom.bookstore.bookstoreapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotNull
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    private LocalDate publishedDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id;
    }

    public String getTitle() {
    	return title; 
    }
    public void setTitle(String title) { 
    	this.title = title; 
    }

    public String getIsbn() { 
    	return isbn;
    }
    public void setIsbn(String isbn) {
    	this.isbn = isbn;
    }

    public BigDecimal getPrice() {
    	return price;
    }
    public void setPrice(BigDecimal price) {
    	this.price = price; 
    }

    public LocalDate getPublishedDate() { 
    	return publishedDate;
    }
    public void setPublishedDate(LocalDate publishedDate) { 
    	this.publishedDate = publishedDate; }

    public Author getAuthor() { 
    	return author; 
    }
    public void setAuthor(Author author) { 
    	this.author = author; 
    }

    public Instant getCreatedAt() { 
    	return createdAt; 	
    }
    public void setCreatedAt(Instant createdAt) {
    	this.createdAt = createdAt; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

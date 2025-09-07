package com.hariom.bookstore.bookstoreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String isbn;
    @NotNull
    private BigDecimal price;
    private LocalDate publishedDate;
    @NotNull
    private Long authorId;

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
    	this.publishedDate = publishedDate;
    }
    public Long getAuthorId() { 
    	return authorId;
    }
    public void setAuthorId(Long authorId) { 
    	this.authorId = authorId;
    }
}

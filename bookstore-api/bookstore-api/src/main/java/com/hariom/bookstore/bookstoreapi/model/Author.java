package com.hariom.bookstore.bookstoreapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String bio;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Long getId() {
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getName() {
    	return name;
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getBio() {
    	return bio; 
    }
    public void setBio(String bio) { 
    	this.bio = bio;
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
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

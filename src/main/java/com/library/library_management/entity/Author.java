package com.library.library_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.library_management.entity.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // matches DTO

    private String name;

    @JsonIgnore // avoids infinite recursion when serializing
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}

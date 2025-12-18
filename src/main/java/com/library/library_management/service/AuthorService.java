package com.library.library_management.service;

import com.library.library_management.DTO.AuthorDto;
import com.library.library_management.entity.Author;
import com.library.library_management.entity.Book;
import com.library.library_management.repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    // CREATE AUTHOR
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    // GET ALL AUTHORS
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    // UPDATE AUTHOR
    public Author updateAuthorById(long id, Author author) {
        Author present = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        present.setName(author.getName());
        return authorRepo.save(present);
    }

    // DELETE AUTHOR
    public void deleteAuthorById(long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepo.delete(author);
    }

    // GET BOOKS BY AUTHOR
    public List<Book> getBooksByAuthorId(long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return author.getBooks();
    }

    // GET AUTHOR WITH BOOK NAMES (DTO)
    public AuthorDto getAuthorWithBooks(long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());

        List<String> bookNames = new ArrayList<>();
        for (Book book : author.getBooks()) {
            bookNames.add(book.getName());
        }
        dto.setBooks(bookNames);

        return dto;
    }
}

package com.library.library_management.service;

import com.library.library_management.entity.Author;
import com.library.library_management.entity.Book;
import com.library.library_management.repository.AuthorRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    //  CREATE AUTHOR
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    //  GET ALL AUTHORS
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    //  UPDATE AUTHOR
    public Author updateAuthorById(int id, Author author) {
        Author present = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        present.setName(author.getName());
        return authorRepo.save(present);
    }

    // DELETE AUTHOR
    public void deleteAuthorById(int id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorRepo.delete(author);
    }



    public List<Book> getBooksByAuthorId(int id) {
       Author author =authorRepo.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
        return  author.getBooks();
    }
}

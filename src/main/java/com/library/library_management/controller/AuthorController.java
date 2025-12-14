package com.library.library_management.controller;

import com.library.library_management.entity.Author;
import com.library.library_management.entity.Book;
import com.library.library_management.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //  CREATE AUTHOR
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    // GET ALL AUTHORS
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    //  UPDATE AUTHOR
    @PutMapping("/{id}")
    public Author updateAuthorById(@PathVariable int id, @RequestBody Author author) {

        return authorService.updateAuthorById(id, author);
    }

    //  DELETE AUTHOR
    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable int id) {
        authorService.deleteAuthorById(id);
        return "Author has been deleted";
    }



    @GetMapping("/{id}/books")
    public List<Book>getBooksByAuthorId(@PathVariable int id) {
        return authorService.getBooksByAuthorId(id);
    }
}

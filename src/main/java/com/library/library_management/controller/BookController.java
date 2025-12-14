package com.library.library_management.controller;

import com.library.library_management.entity.Book;
import com.library.library_management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //  CREATE BOOK WITH AUTHOR
    @PostMapping("/author/{authorId}")
    public Book createBook(@PathVariable int authorId, @RequestBody Book book) {

        return bookService.createBook(authorId, book);
    }

    // GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //  UPDATE BOOK
    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable int id, @RequestBody Book book) {

        return bookService.updateBookById(id, book);
    }

    //  DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }


}

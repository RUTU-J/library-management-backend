package com.library.library_management.controller;

import com.library.library_management.DTO.BookDto;
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

    // CREATE BOOK WITH AUTHOR
    @PostMapping("/author/{authorId}")
    public BookDto createBook(@PathVariable Long authorId, @RequestBody Book book) {
        Book savedBook = bookService.createBook(authorId, book);
        return bookService.getBookDtoById(savedBook.getId());
    }

    // GET ALL BOOKS
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    // UPDATE BOOK
    @PutMapping("/{id}")
    public BookDto updateBookById(@PathVariable int id,
                                  @RequestBody Book book,
                                  @RequestParam(required = false) Long authorId) {
        Book updatedBook = bookService.updateBookById(id, book, authorId);
        return bookService.getBookDtoById(updatedBook.getId());
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }

    // GET SINGLE BOOK BY ID
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable int id) {
        return bookService.getBookDtoById(id);
    }
}

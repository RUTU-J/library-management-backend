package com.library.library_management.service;

import com.library.library_management.entity.Author;
import com.library.library_management.entity.Book;
import com.library.library_management.repository.AuthorRepo;
import com.library.library_management.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    // CREATE BOOK WITH AUTHOR
    public Book createBook(int authorId, Book book) {

        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        //  SET relationship (owning side)
        book.setAuthor(author);

        return bookRepo.save(book);
    }

    //  GET ALL BOOKS
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    //  UPDATE BOOK
    public Book updateBookById(int id, Book book) {
        Book present = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        present.setName(book.getName());

        // Optional: update author if needed later
        return bookRepo.save(present);
    }

    //  DELETE BOOK
    public String deleteBookById(int id) {
        Book present = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepo.delete(present);
        return "Book Deleted Successfully";
    }
}

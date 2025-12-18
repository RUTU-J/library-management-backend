package com.library.library_management.service;

import com.library.library_management.DTO.BookDto;
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
    public Book createBook(long authorId, Book book) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Set relationship (owning side)
        book.setAuthor(author);

        return bookRepo.save(book);
    }

    // GET ALL BOOKS AS DTO
    public List<BookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(book -> {
                    BookDto dto = new BookDto();
                    dto.setId(book.getId());
                    dto.setName(book.getName());
                    dto.setAuthorName(book.getAuthor().getName());
                    return dto;
                })
                .toList();
    }

    // UPDATE BOOK NAME (optional: update author too)
    public Book updateBookById(long id, Book book, Long authorId) {
        Book present = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        present.setName(book.getName());

        if (authorId != null) {
            Author author = authorRepo.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            present.setAuthor(author);
        }

        return bookRepo.save(present);
    }

    // DELETE BOOK
    public String deleteBookById(long id) {
        Book present = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepo.delete(present);
        return "Book Deleted Successfully";
    }

    // GET SINGLE BOOK AS DTO (Optional helper)
    public BookDto getBookDtoById(long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setAuthorName(book.getAuthor().getName());

        return dto;
    }
}

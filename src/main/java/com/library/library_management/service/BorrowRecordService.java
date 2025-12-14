package com.library.library_management.service;

import com.library.library_management.entity.AppUser;
import com.library.library_management.entity.Book;
import com.library.library_management.entity.BorrowRecord;
import com.library.library_management.repository.AppUserRepo;
import com.library.library_management.repository.BookRepo;
import com.library.library_management.repository.BorrowRecordRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepo borrowRecordRepo;
    private final AppUserRepo appUserRepo;
    private final BookRepo bookRepo;

    public BorrowRecordService(BorrowRecordRepo borrowRecordRepo,
                               AppUserRepo appUserRepo,
                               BookRepo bookRepo) {
        this.borrowRecordRepo = borrowRecordRepo;
        this.appUserRepo = appUserRepo;
        this.bookRepo = bookRepo;
    }

    // BORROW BOOK
    public BorrowRecord borrowBook(Long userId, int bookId) {

        AppUser user = appUserRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(new Date());
        record.setReturnDate(null);

        return borrowRecordRepo.save(record);
    }

    // RETURN BOOK
    public BorrowRecord returnBook(Long recordId) {

        BorrowRecord record = borrowRecordRepo.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        record.setReturnDate(new Date());
        return borrowRecordRepo.save(record);
    }

    // GET ALL
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordRepo.findAll();
    }
}

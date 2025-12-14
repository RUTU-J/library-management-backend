package com.library.library_management.controller;

import com.library.library_management.entity.BorrowRecord;
import com.library.library_management.service.BorrowRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    // BORROW BOOK
    @PostMapping("/user/{userId}/book/{bookId}")
    public BorrowRecord borrowBook(
            @PathVariable Long userId,
            @PathVariable int bookId) {

        return borrowRecordService.borrowBook(userId, bookId);
    }

    // RETURN BOOK
    @PutMapping("/return/{recordId}")
    public BorrowRecord returnBook(@PathVariable Long recordId) {
        return borrowRecordService.returnBook(recordId);
    }

    // GET ALL BORROW RECORDS
    @GetMapping
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordService.getAllRecords();
    }
}

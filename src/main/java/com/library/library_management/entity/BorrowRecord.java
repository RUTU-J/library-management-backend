package com.library.library_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date borrowDate;
    private Date returnDate;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;



    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}

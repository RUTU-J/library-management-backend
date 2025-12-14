package com.library.library_management.repository;

import com.library.library_management.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepo extends JpaRepository<BorrowRecord,Long> {
}

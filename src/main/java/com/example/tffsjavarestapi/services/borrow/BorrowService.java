package com.example.tffsjavarestapi.services.borrow;

import com.example.tffsjavarestapi.models.entities.Borrow;
import com.example.tffsjavarestapi.utils.crud.Read;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowService extends Read<Borrow, Long> {
    Borrow create(Long authorId, List<Long> bookId);
    void back(Long borrowId);
    Borrow findByTitle(String title);
}

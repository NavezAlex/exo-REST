package com.example.tffsjavarestapi.services.book;

import com.example.tffsjavarestapi.models.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAll();

    Long delete(Long id);

    Book updateAuthor(Long id, List<Long> authorIds);

    List<Book> getAllById(List<Long> bookIds);
}

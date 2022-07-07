package com.example.tffsjavarestapi.services.author;

import com.example.tffsjavarestapi.models.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findAllByIds(List<Long> ids);
}

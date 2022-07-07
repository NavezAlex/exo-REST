package com.example.tffsjavarestapi.services.author;

import com.example.tffsjavarestapi.models.entities.Author;
import com.example.tffsjavarestapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllByIds(List<Long> ids) {
        return this.authorRepository.findAllByIdIn(ids);
    }
}

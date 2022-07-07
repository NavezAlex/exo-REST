package com.example.tffsjavarestapi.repositories;

import com.example.tffsjavarestapi.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByIdIn(List<Long> ids);
}

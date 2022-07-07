package com.example.tffsjavarestapi.repositories;

import com.example.tffsjavarestapi.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b")
    List<Book> findAll();

    List<Book> findAllByActive(boolean active);

    List<Book> findAllByIdIn(List<Long> ids);
}

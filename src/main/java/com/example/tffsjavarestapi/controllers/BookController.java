package com.example.tffsjavarestapi.controllers;

import com.example.tffsjavarestapi.models.dtos.BookPatchAuthorDTO;
import com.example.tffsjavarestapi.models.entities.Book;
import com.example.tffsjavarestapi.services.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class BookController extends BaseRestController {
    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("book") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = {"", "/", "/all"}, name = "BookController.GetAll")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @PatchMapping(path = {"/{id:[0-9]+}/author"}, name = "BookController.PatchAuthor")
    public Book patchAuthor(@PathVariable Long id, @RequestBody BookPatchAuthorDTO dto) {
        return this.bookService.updateAuthor(id, dto.getAuthorIds());
    }

    @DeleteMapping(path = {"/{id:[0-9]+}"}, name= "BookController.DeleteOne")
    public void deleteAction(@PathVariable Long id) {
        this.bookService.delete(id);
    }
}

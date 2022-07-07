package com.example.tffsjavarestapi.services.book;

import com.example.tffsjavarestapi.exceptions.CrudException;
import com.example.tffsjavarestapi.exceptions.NotFoundException;
import com.example.tffsjavarestapi.models.entities.Author;
import com.example.tffsjavarestapi.models.entities.Book;
import com.example.tffsjavarestapi.repositories.BookRepository;
import com.example.tffsjavarestapi.services.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("book")
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAllByActive(true);
    }

    @Override
    public Long delete(Long id) {
        Optional<Book> data = bookRepository.findById(id);
        data.ifPresent(book -> {
            book.setActive(false);
            bookRepository.save(book);
        });

        return 1L;
    }

    @Override
    public Book updateAuthor(Long id, List<Long> authorIds) {
        Optional<Book> data = bookRepository.findById(id);
        if (data.isEmpty()) {
            throw new NotFoundException(HttpStatus.PRECONDITION_FAILED, "BookService.updateAuthor(Long, List<Long>)", id, "No book found for id "+ id);
        }

        List<Author> authors = this.authorService.findAllByIds(authorIds);
        if (authors.size() != authorIds.size()) {
            throw new CrudException("BookService.updateAuthor(Long, List<Long>)", "An author doesn't exist", null);
        }

        Book book = data.get();
        book.clearAuthor();
        for(Author a: authors) {
            book.addAuthor(a);
        }

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllById(List<Long> bookIds) {
        return bookRepository.findAllByIdIn(bookIds);
    }
}

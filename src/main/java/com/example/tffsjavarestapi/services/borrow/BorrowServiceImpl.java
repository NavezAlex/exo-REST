package com.example.tffsjavarestapi.services.borrow;

import com.example.tffsjavarestapi.models.entities.Book;
import com.example.tffsjavarestapi.models.entities.Borrow;
import com.example.tffsjavarestapi.repositories.BorrowRepository;
import com.example.tffsjavarestapi.services.book.BookService;
import com.example.tffsjavarestapi.services.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService{
    private final BorrowRepository borrowRepository;
    private final BookService bookService;
    private final CustomerServiceImpl customerService;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository, BookService bookService, CustomerServiceImpl customerService) {
        this.borrowRepository = borrowRepository;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    @Override
    public Borrow create(Long customerId, List<Long> bookIds) {
        Borrow borrow = new Borrow();
        List<Book> books = bookService.getAllById(bookIds);
        borrow.setCustomer(this.customerService.findOne(customerId));

        books.forEach(borrow::addBook);

        borrow = this.borrowRepository.save(borrow);

        borrow.getCustomer();
        return borrow;
    }

    @Override
    public void back(Long borrowId) {
        Optional<Borrow> data = this.borrowRepository.findById(borrowId);
        data.ifPresent(b -> {
            b.close();
            this.borrowRepository.save(b);
        });
    }

    @Override
    public Borrow findByTitle(String title) {
        return this.borrowRepository.findByBookTitle(title);
    }

    @Override
    public List<Borrow> findAll() {
        return this.borrowRepository.findAll();
    }

    @Override
    public Page<Borrow> findAll(int page) {
        return this.borrowRepository.findAll(PageRequest.of(page, DEFAULT_SIZE));
    }

    @Override
    public Page<Borrow> findAll(int page, int size) {
        return this.borrowRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Borrow> findAllByIds(List<Long> ids) {
        return this.borrowRepository.findAllByIdIn(ids);
    }

    @Override
    public Page<Borrow> findAllByIds(List<Long> ids, int page) {
        return this.borrowRepository.findAllByIdIn(ids, PageRequest.of(page, DEFAULT_SIZE));
    }

    @Override
    public Page<Borrow> findAllByIds(List<Long> ids, int page, int size) {
        return this.borrowRepository.findAllByIdIn(ids, PageRequest.of(page, size));
    }

    @Override
    public Borrow findOne(Long id) {
        return this.borrowRepository.findById(id).orElse(null);
    }
}

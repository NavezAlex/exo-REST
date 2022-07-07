package com.example.tffsjavarestapi.services.customer;

import com.example.tffsjavarestapi.models.entities.Customer;
import com.example.tffsjavarestapi.repositories.CustomerRepository;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer create(Customer e) {
        return this.customerRepository.save(e);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(int page) {
        return this.customerRepository.findAll(PageRequest.of(page, DEFAULT_SIZE));
    }

    @Override
    public Page<Customer> findAll(int page, int size) {
        return this.customerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Deprecated
    public List<Customer> findAllByIds(List<Long> ids) {
        throw new NotYetImplementedException();
    }

    @Override
    @Deprecated
    public Page<Customer> findAllByIds(List<Long> ids, int page) {
        throw  new NotYetImplementedException();
    }

    @Override
    @Deprecated
    public Page<Customer> findAllByIds(List<Long> ids, int page, int size) {

        throw  new NotYetImplementedException();
    }

    @Override
    public Customer findOne(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}

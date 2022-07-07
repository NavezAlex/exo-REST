package com.example.tffsjavarestapi.services.customer;

import com.example.tffsjavarestapi.models.entities.Customer;
import com.example.tffsjavarestapi.utils.crud.Create;
import com.example.tffsjavarestapi.utils.crud.Read;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService extends Create<Customer>, Read<Customer, Long> {
}

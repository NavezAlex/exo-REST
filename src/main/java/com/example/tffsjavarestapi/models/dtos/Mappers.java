package com.example.tffsjavarestapi.models.dtos;

import com.example.tffsjavarestapi.models.dtos.borrow.BorrowCreateReponse;
import com.example.tffsjavarestapi.models.entities.Book;
import com.example.tffsjavarestapi.models.entities.Borrow;

import java.util.stream.Collectors;

public abstract class Mappers {

    public static BorrowCreateReponse fromEntity(Borrow entity) {
        BorrowCreateReponse response = BorrowCreateReponse.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedDate())
                .customerFullName(String.format("%s %s", entity.getCustomer().getLastname(), entity.getCustomer().getFirstname()))
                .build();
        response.setBooksTitle(entity.getBooks().stream().map(Book::getTitle).collect(Collectors.toList()));

        return response;
    }
}

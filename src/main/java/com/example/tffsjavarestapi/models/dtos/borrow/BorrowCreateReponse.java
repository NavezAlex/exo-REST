package com.example.tffsjavarestapi.models.dtos.borrow;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class BorrowCreateReponse {
    private Long id;
    private String customerFullName;
    private LocalDate createdAt;
    private List<String> booksTitle = new ArrayList<>();
}

package com.example.tffsjavarestapi.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class BookPatchAuthorDTO {
    @Getter @Setter
    private List<Long> authorIds = new ArrayList<Long>();
}

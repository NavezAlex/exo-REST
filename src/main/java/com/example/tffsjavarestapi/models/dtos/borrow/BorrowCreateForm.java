package com.example.tffsjavarestapi.models.dtos.borrow;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Validated
public class BorrowCreateForm {
    @NotNull(message = "Customer id must be provide")
    @Min(value = 1, message = "Customer id must be gt 0")
    private long customerId;
    @NotNull(message = "BookIds must be provide")
    @NotEmpty(message = "Books cannot be empty")
    private List<Long> bookIds;
}

package com.example.tffsjavarestapi.models.dtos;

import com.example.tffsjavarestapi.utils.lombok.Collection;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PageDTO {
    private List<Object> content;
    private boolean last;
    private long totalElement;
    private long totalPages;
    private boolean first;

    public static <T> PageDTO fromPage(Page<T> page) {
        return PageDTO.builder()
                .content((List<Object>) page.getContent())
                .last(page.isLast())
                .first(page.isFirst())
                .totalPages(page.getTotalPages())
                .totalElement(page.getTotalElements())
                .build();
    }
}

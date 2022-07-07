package com.example.tffsjavarestapi.models.entities;

import lombok.*;
import lombok.experimental.Delegate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrow extends BaseEntity implements Serializable {
    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private LocalDate backDate;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false)
    @Getter @Setter
    private Customer customer;

    @ManyToMany(targetEntity = Book.class)
    @Getter @Setter
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void close() {
        this.setActive(false);
        this.backDate = LocalDate.now();
    }
}

package com.example.tffsjavarestapi.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity implements Serializable {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String title;

    @Getter @Setter
    @Column(nullable = false)
    private String description;

    @ManyToMany(targetEntity = Author.class, cascade = {CascadeType.ALL})
    @Getter @Setter
    @ToString.Exclude
    private Set<Author> authors = new HashSet<Author>();


    public void addAuthor(Author author) {
        this.authors.add(author);
    }
    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }
    public void clearAuthor() { this.authors.clear(); }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.example.tffsjavarestapi.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Write implements Serializable {
    @EmbeddedId
    @Getter @Setter
    private WriteId id;

    private int prc;

    @ManyToOne(targetEntity = Author.class)
    @MapsId(value = "authorId")
    @Getter @Setter
    private Author author;

    @ManyToOne(targetEntity = Book.class)
    @MapsId(value = "bookId")
    @Getter @Setter
    private Book book;

    public float getPrc() {
        return prc / 100F;
    }

    public void setPrc(int prc) {
        this.prc = prc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Write write = (Write) o;
        return id != null && Objects.equals(id, write.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Embeddable
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WriteId implements Serializable {
        @Getter @Setter
        private Long authorId;

        @Getter @Setter
        private Long bookId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
            WriteId writeId = (WriteId) o;
            return authorId != null && Objects.equals(authorId, writeId.authorId)
                    && bookId != null && Objects.equals(bookId, writeId.bookId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(authorId, bookId);
        }
    }
}

package com.example.tffsjavarestapi.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@MappedSuperclass
@ToString
public abstract class BaseEntity {
    @Getter @Setter
    private LocalDate createdDate;
    @Getter @Setter
    private LocalDate updatedDate;
    @Getter @Setter
    private boolean active = true;

    @PrePersist
    public void prePersistAction() {
        createdDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdateAction() {
        updatedDate = LocalDate.now();
    }
}

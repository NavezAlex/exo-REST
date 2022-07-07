package com.example.tffsjavarestapi.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity implements Serializable {
    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String lastname;

    @Getter @Setter
    @Column(nullable = false)
    private String firstname;

    @Getter @Setter
    @Column(nullable = false)
    private LocalDate birthDate;
}

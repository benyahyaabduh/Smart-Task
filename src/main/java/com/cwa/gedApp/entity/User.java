package com.cwa.gedApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Le nom est obligatoire")
    private String firstName;

    @Column(length = 50)
    @NotBlank(message = "Le prénom est obligatoire")
    private String lastName;

    @Column(length = 50)
    private String email;
    @Column
    private String password;
    @Column
    private LocalDateTime createdDate;

    private String role; //AdminOuUser


}

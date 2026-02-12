package com.cwa.gedApp.entity;

import com.cwa.gedApp.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Le nom est obligatoire")
    private String firstName;

    @Column(length = 50)
    @NotBlank(message = "Le prénom est obligatoire")
    private String userName;

    @Column(length = 50)
    private String email;
    @Column
    private String password;
    @Column
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}

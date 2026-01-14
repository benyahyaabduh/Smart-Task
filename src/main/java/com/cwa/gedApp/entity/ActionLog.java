package com.cwa.crudApp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="ACTIONLOG")
public class ActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String action; // UPLOAD, DELETE, VIEW
    @Column
    private LocalDateTime actionDate;




}

package com.cwa.gedApp.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    private String fileName;

    @Column
    private Date dateSurvenance;

    @Column(length = 20)
    private int police;

    @Column
    private double fraisEngages;

    @Column(length = 6)
    private int affiliation;

    @Column(length = 2)
    private int filiale;

    @Column(length = 20)
    private long sinistre;

    @Column(length = 150)
    private String description;

    @Column
    private Date uploadDate;
    //uploadedBy (User)
}

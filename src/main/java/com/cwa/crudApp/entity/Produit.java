package com.cwa.crudApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUIT")

public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 150)
    private String description;
    private Integer prix ;

    public Produit(Long id, String nom, String description, Integer prix) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
    public Produit() {

    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}

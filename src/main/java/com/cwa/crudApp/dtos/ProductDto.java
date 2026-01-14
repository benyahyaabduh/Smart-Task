package com.cwa.crudApp.dtos;

import jakarta.persistence.Column;


public class ProduitDto {


    private String nom;
    private String description;
    private double prix ;

    public ProduitDto(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
}

    public ProduitDto() {
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

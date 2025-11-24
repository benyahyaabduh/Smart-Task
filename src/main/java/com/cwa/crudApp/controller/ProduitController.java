package com.cwa.crudApp.controller;

import com.cwa.crudApp.entity.Produit;
import com.cwa.crudApp.services.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produit")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }


@PostMapping("/AddProduct")
    public Produit create (@RequestBody Produit p){
        return produitService.creer(p);
    }

@GetMapping("/GetAll")
 public List<Produit> getAll (){
        return produitService.lire();
 }

@PutMapping("/update/{id}")
 public Produit updateProduit (@PathVariable long id,@RequestBody Produit produit){
        return produitService.modifier(id,produit);
 }


}

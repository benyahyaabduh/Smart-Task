package com.cwa.crudApp.controller;

import com.cwa.crudApp.dtos.ProduitDto;
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
    public ProduitDto create (@RequestBody ProduitDto p){
        return produitService.add(p);
    }

    @GetMapping("/GetAll")
    public List<Produit> getAll (){
        return produitService.find();
 }

    @GetMapping("/FindBydId/{id}")
    public ProduitDto findById(@PathVariable Long id){
        return produitService.findById(id);
 }

    @PutMapping("/update/{id}")
    public ProduitDto updateProduit (@PathVariable long id,@RequestBody ProduitDto produitDto){
        return produitService.update(id,produitDto);
 }

    @PutMapping("/delete{id}")
    public void deleteProduct (@PathVariable long id){
        produitService.delete(id);
 }


}

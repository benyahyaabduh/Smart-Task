package com.cwa.crudApp.services;

import com.cwa.crudApp.entity.Produit;
import com.cwa.crudApp.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService{

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }



    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p -> {
                    p.setNom(produit.getNom());
                    p.setPrix(produit.getPrix());
                    p.setDescription(produit.getDescription());
                    return produitRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Produit Non trouve"));
    }



    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimer avec succes";
    }
}

package com.cwa.crudApp.services;

import com.cwa.crudApp.dtos.ProduitDto;
import com.cwa.crudApp.entity.Produit;
import com.cwa.crudApp.mapper.ProduitMapper;
import com.cwa.crudApp.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService{

    private final ProduitRepository produitRepository;

    @Autowired
    private ProduitMapper produitMapper;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public ProduitDto add(ProduitDto produitDto) {
        Produit produit = produitMapper.toEntity(produitDto);
        Produit savedProduit = produitRepository.save(produit);
        return produitMapper.toDTO(savedProduit) ;
    }


    @Override
    public ProduitDto update(Long id, ProduitDto produitDto) {

        Produit produit = produitRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Produit non trouvee"));
        produitMapper.updateProduitFromDto(produitDto, produit);
        Produit updated = produitRepository.save(produit);
        return produitMapper.toDTO(updated);
    }




    @Override
    public List<Produit> find() {
        return produitRepository.findAll();
    }


     public ProduitDto findById(Long id) {
         Produit produit = produitRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Produit Non Trouvee"));

        return produitMapper.toDTO(produit);

     }














    @Override
    public String delete(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimer avec succes";
    }
}

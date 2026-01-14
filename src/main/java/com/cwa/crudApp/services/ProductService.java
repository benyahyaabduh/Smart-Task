package com.cwa.crudApp.services;

import com.cwa.crudApp.dtos.ProduitDto;
import com.cwa.crudApp.entity.Produit;

import java.util.List;

public interface ProduitService {

   ProduitDto add (ProduitDto produitDto);
   List<Produit> find();
   ProduitDto update (Long id , ProduitDto produitDto);
   ProduitDto findById(Long id);

   String delete (Long id);
}

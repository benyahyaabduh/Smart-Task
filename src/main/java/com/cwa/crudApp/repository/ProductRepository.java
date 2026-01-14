package com.cwa.crudApp.repository;

import com.cwa.crudApp.dtos.ProduitDto;
import com.cwa.crudApp.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}

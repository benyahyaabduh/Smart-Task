package com.cwa.crudApp.mapper;

import com.cwa.crudApp.dtos.ProduitDto;
import com.cwa.crudApp.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProduitMapper {
    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

    ProduitDto toDTO(Produit produit);

    Produit toEntity(ProduitDto produitDTO);

    void updateProduitFromDto(ProduitDto dto, @MappingTarget Produit entity);

}

package com.cwa.gedApp.mapper;

import com.cwa.gedApp.dtos.ProductDto;
import com.cwa.gedApp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDTO(Product product);

    Product toEntity(ProductDto productDTO);

    void updateProductFromDto(ProductDto dto, @MappingTarget Product entity);

}

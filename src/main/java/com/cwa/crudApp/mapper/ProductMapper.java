package com.cwa.crudApp.mapper;

import com.cwa.crudApp.dtos.ProductDto;
import com.cwa.crudApp.entity.Product;
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

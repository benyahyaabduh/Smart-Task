package com.cwa.crudApp.services;

import com.cwa.crudApp.dtos.ProductDto;
import com.cwa.crudApp.entity.Product;

import java.util.List;

public interface ProductService {

   ProductDto add (ProductDto productDto);
   List<Product> findAll();
   ProductDto update (Long id , ProductDto productDto);
   ProductDto findById(Long id);

   String delete (Long id);
}

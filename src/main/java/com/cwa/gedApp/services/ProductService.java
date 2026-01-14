package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.ProductDto;
import com.cwa.gedApp.entity.Product;

import java.util.List;

public interface ProductService {

   ProductDto add (ProductDto productDto);
   List<Product> findAll();
   ProductDto update (Long id , ProductDto productDto);
   ProductDto findById(Long id);

   String delete (Long id);
}

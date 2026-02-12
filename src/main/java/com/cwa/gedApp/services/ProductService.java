package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.ProductDto;
import com.cwa.gedApp.entity.Task;

import java.util.List;

public interface ProductService {

   ProductDto add (ProductDto productDto);
   List<Task> findAll();
   ProductDto update (Long id , ProductDto productDto);
   ProductDto findById(Long id);

   String delete (Long id);
}

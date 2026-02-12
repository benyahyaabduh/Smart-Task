package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.ProductDto;
import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.mapper.ProductMapper;
import com.cwa.gedApp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDto add(ProductDto productDto) {
        Task task = productMapper.toEntity(productDto);
        Task savedTask = productRepository.save(task);
        return productMapper.toDTO(savedTask) ;
    }


    @Override
    public ProductDto update(Long id, ProductDto productDto) {

        Task task = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Produit non trouvee"));
        productMapper.updateProductFromDto(productDto, task);
        Task updated = productRepository.save(task);
        return productMapper.toDTO(updated);
    }




    @Override
    public List<Task> findAll() {
        return productRepository.findAll();
    }


     public ProductDto findById(Long id) {
         Task task = productRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Produit Non Trouvee"));

        return productMapper.toDTO(task);

     }














    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Produit supprimer avec succes";
    }
}

package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.ProductDto;
import com.cwa.gedApp.entity.Product;
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
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct) ;
    }


    @Override
    public ProductDto update(Long id, ProductDto productDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Produit non trouvee"));
        productMapper.updateProductFromDto(productDto, product);
        Product updated = productRepository.save(product);
        return productMapper.toDTO(updated);
    }




    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


     public ProductDto findById(Long id) {
         Product product = productRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Produit Non Trouvee"));

        return productMapper.toDTO(product);

     }














    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Produit supprimer avec succes";
    }
}

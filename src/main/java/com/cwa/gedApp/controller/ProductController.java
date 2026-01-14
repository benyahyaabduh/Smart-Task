package com.cwa.crudApp.controller;

import com.cwa.crudApp.dtos.ProductDto;
import com.cwa.crudApp.entity.Product;
import com.cwa.crudApp.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/AddProduct")
    public ProductDto create (@Valid @RequestBody ProductDto p){
        return productService.add(p);
    }

    @GetMapping("/GetAll")
    public List<Product> getAll (){
        return productService.findAll();
 }

    @GetMapping("/FindBydId/{id}")
    public ProductDto findById(@PathVariable Long id){
        return productService.findById(id);
 }

    @PutMapping("/Update/{id}")
    public ProductDto updateProduit (@PathVariable long id, @RequestBody ProductDto productDto){
        return productService.update(id, productDto);
 }

    @PutMapping("/delete{id}")
    public void deleteProduct (@PathVariable long id){
        productService.delete(id);
 }


}

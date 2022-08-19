package com.example.dbtema7.service;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public List<Product> getTheProducts(){
        return productRepository.findAll().stream()
                .filter(product -> !product.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllTheProducts(){
        return productRepository.getAllTheProducts();
    }

    public void updateStock(Integer id, Integer stock){
        productRepository.updateStock(id,stock);
    }

    public void incrementStock(Integer id){
        productRepository.incrementStock(id);
    }

    public void decrementStock(Integer id){
        productRepository.decrementStock(id);
    }
}
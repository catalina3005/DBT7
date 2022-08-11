package com.example.dbtema7.controller;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping
    public List<Product> getAllNoDeleted(){
        return productService.getAllNoDeleted();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.insert(product);
    }

    @PutMapping("increment/{id}")
    public void incrementProduct(@PathVariable Integer id){
        productService.incrementProduct(id);
    }
    @PutMapping("decrement/{id}")
    public void decrementProduct(@PathVariable Integer id){
        productService.decrementProduct(id);
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.delete(id);
    }
    @PutMapping("/stockUpdate/{id}/{stock}")
    public void stockUpdate(@PathVariable Integer id,@PathVariable Integer stock){
        productService.stockUpdate(id, stock);
    }
}
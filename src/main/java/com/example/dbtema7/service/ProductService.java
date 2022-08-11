package com.example.dbtema7.service;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public List<Product> getAllNoDeleted(){
        return getAll().stream().filter(product -> !product.isDeleted()).collect(Collectors.toList());
    }

    public void insert(Product product){
        productRepository.save(product);
    }

    public void incrementProduct(Integer id){
        productRepository.incrementStock(id);

//        Optional<Product> product = productRepository.findById(id);
//        product.setInitialStock(product.getInitialStock() + 1);
//        productRepository.save(product);

    }

    public void decrementProduct(Integer id){
        productRepository.decrementStock(id);

//        Product product = productRepository.findById(id);
//        product.setInitialStock(product.getInitialStock() - 1);
//        productRepository.save(product);
    }

    public void delete(Integer id){
        Product p = productRepository.findById(id).get();
        p.setDeleted(true);
        productRepository.save(p);
    }

    public void stockUpdate(Integer id, Integer stock){
        Product p = productRepository.findById(id).get();
        p.setInitialStock(stock);
        productRepository.save(p);
    }
}


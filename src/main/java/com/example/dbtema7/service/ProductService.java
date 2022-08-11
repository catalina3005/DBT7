package com.example.dbtema7.service;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        System.out.println(product);
        productRepository.save(product);

    }

    public void updateProductStock(Integer productId,Integer initialStock){
        productRepository.updateProduct(productId,initialStock);
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }

    public List<Product> findAllProducts(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedProductFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Product> products =  productRepository.findAll();
        session.disableFilter("deletedProductFilter");
        return products;
    }

    public void incrementStock(Integer productId){
        productRepository.incrementStock(productId);
    }

    public void updateStock(Integer productId){
        productRepository.updateStock(productId);
    }



}
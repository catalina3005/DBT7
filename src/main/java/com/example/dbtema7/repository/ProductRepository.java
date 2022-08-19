package com.example.dbtema7.repository;
import com.example.dbtema7.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.deleted = true WHERE p.id = :id")
    void deleteById(Integer id);

    @Query("SELECT p FROM Product p where p.deleted = false")
    List<Product> getAllTheProducts();

    List<Product> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = :newStock WHERE p.id = :id")
    void updateStock(Integer id,Integer newStock);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock + 1 WHERE p.id = :id")
    void incrementStock(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p set p.stock = p.stock - 1 WHERE p.id = :id")
    void decrementStock(Integer id);
}
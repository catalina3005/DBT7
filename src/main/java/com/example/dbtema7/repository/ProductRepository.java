package com.example.dbtema7.repository;
import com.example.dbtema7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    @Transactional
    @Modifying
    @Query(value = "UPDATE Product p set p.initialStock = p.initialStock + 1 WHERE p.id = :id")
    void incrementStock(@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Product p set p.initialStock = p.initialStock - 1 WHERE p.id = :id")
    void decrementStock(@Param("id") Integer id);
}

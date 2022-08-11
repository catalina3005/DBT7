package com.example.dbtema7.repository;
import com.example.dbtema7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAll();

    @Modifying
    @Transactional
    @Query("update Product u set u.initialStock = :initialStock where u.id = :id")
    void updateProduct(@Param(value = "id") Integer id, @Param(value = "initialStock") Integer initialStock);

    @Modifying
    @Transactional
    @Query("UPDATE Product t set t.initialStock = t.initialStock - 1 WHERE t.id = :id")
    void updateStock(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product t set t.initialStock = t.initialStock + 1 WHERE t.id = :id")
    void incrementStock(Integer id);

}
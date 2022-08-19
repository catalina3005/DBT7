package com.example.dbtema7.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private ProductType productType;

    @NotNull
    private Integer stock;

    @Column(nullable = false)
    private boolean deleted;

    private Integer price;

    public Product(String name, String code, ProductType productType, Integer stock, boolean deleted, Integer price) {
        this.name = name;
        this.code = code;
        this.productType = productType;
        this.stock = stock;
        this.deleted = deleted;
        this.price = price;
    }}
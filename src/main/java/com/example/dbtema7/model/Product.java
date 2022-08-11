package com.example.dbtema7.model;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String barCode;
    @NotNull
    private String name;
    private Integer initialStock;
    private boolean deleted = false;
    private ProductType productType;

}
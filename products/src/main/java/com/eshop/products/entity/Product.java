package com.eshop.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_seq",
            sequenceName = "product_id_seq", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @ManyToOne
    private Discount discount;
    @ManyToOne
    private ProductCategory productCategory;
    private float price;
    @Column(nullable = false)
    private boolean active;
}

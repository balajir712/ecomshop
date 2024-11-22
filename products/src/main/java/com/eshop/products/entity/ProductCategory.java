package com.eshop.products.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @SequenceGenerator(name = "id_seq",
            sequenceName = "id_seq", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;
}

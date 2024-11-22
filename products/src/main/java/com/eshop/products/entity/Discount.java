package com.eshop.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "discount")
public class Discount {
    @Id
    @SequenceGenerator(name = "discount_id_seq",
            sequenceName = "diuscount_id_seq", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @Column(nullable = false)
    private float discount;
    @Column(nullable = false)
    private boolean active;
}

package com.eshop.products.repository;

import com.eshop.products.entity.Discount;
import com.eshop.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

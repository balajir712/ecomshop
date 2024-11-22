package com.eshop.products.repository;

import com.eshop.products.entity.Discount;
import com.eshop.products.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}

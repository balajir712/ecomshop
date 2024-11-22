package com.eshop.products.service;

import com.eshop.products.entity.ProductCategory;
import com.eshop.products.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory save(ProductCategory newCategory) {
        return productCategoryRepository.save(newCategory);
    }

    public Optional<ProductCategory> findById(Integer id) {
        return productCategoryRepository.findById(id);
    }

    public ProductCategory update(ProductCategory newCategory) {
        return productCategoryRepository.findById(newCategory.getId()).map(category -> {
                    category.setName(newCategory.getName());
                    category.setDescription(newCategory.getDescription());
                    return productCategoryRepository.save(newCategory);
                })
                .orElseGet(() ->
                     productCategoryRepository.save(newCategory)
                );
    }

    public void deleteById(Integer id) {
        productCategoryRepository.deleteById(id);
    }
}

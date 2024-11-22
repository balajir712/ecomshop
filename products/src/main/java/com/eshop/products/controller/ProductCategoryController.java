package com.eshop.products.controller;

import com.eshop.products.entity.ProductCategory;
import com.eshop.products.exception.ProductCategoryException;
import com.eshop.products.repository.ProductCategoryRepository;
import com.eshop.products.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public List<ProductCategory> getProductCategories(){
        return productCategoryService.getAllProductCategories();
    }

    @PostMapping("/categories")
    ProductCategory createProductCategory(@RequestBody ProductCategory newCategory) {
        return productCategoryService.save(newCategory);
    }

    @GetMapping("/categories/{id}")
    ProductCategory getCategory(@PathVariable Integer id) throws ProductCategoryException {
        return productCategoryService.findById(id)
                .orElseThrow(() -> new ProductCategoryException("Category not found"));
    }

    @PutMapping("/categories")
    ProductCategory updateCategory(@RequestBody ProductCategory newCategory) {
        return productCategoryService.update(newCategory);
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Integer id) {
        productCategoryService.deleteById(id);
    }
}

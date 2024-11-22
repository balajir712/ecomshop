package com.eshop.products.controller;

import com.eshop.products.entity.Product;
import com.eshop.products.exception.ProductException;
import com.eshop.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getproducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    Product createProduct(@RequestBody Product newProduct) {
        return productService.save(newProduct);
    }

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Integer id) throws ProductException {
        return productService.findById(id)
                .orElseThrow(() -> new ProductException("Category not found"));
    }

    @PutMapping("/products")
    Product updateProduct(@RequestBody Product newProduct) {
        return productService.update(newProduct);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }
}

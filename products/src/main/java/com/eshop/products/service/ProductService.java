package com.eshop.products.service;

import com.eshop.products.entity.Product;
import com.eshop.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product update(Product newProduct) {
        return productRepository.findById(newProduct.getId()).map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setProductCategory(newProduct.getProductCategory());
                    product.setDiscount(newProduct.getDiscount());
                    product.setPrice(newProduct.getPrice());
                    product.setActive(newProduct.isActive());
                    return productRepository.save(newProduct);
                })
                .orElseGet(() ->
                     productRepository.save(newProduct)
                );
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}

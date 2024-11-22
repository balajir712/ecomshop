package com.eshop.products.service;

import com.eshop.products.entity.Discount;
import com.eshop.products.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount save(Discount newCategory) {
        return discountRepository.save(newCategory);
    }

    public Optional<Discount> findById(Integer id) {
        return discountRepository.findById(id);
    }

    public Discount update(Discount newDiscount) {
        return discountRepository.findById(newDiscount.getId()).map(discount -> {
                    discount.setName(newDiscount.getName());
                    discount.setDescription(newDiscount.getDescription());
                    discount.setDiscount(newDiscount.getDiscount());
                    discount.setActive(newDiscount.isActive());
                    return discountRepository.save(newDiscount);
                })
                .orElseGet(() ->
                     discountRepository.save(newDiscount)
                );
    }

    public void deleteById(Integer id) {
        discountRepository.deleteById(id);
    }
}

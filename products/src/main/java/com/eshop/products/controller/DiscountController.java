package com.eshop.products.controller;

import com.eshop.products.entity.Discount;
import com.eshop.products.exception.DiscountException;
import com.eshop.products.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping("/discounts")
    public List<Discount> getDiscounts(){
        return discountService.getAllDiscounts();
    }

    @PostMapping("/discounts")
    Discount createDiscount(@RequestBody Discount newDiscount) {
        return discountService.save(newDiscount);
    }

    @GetMapping("/discounts/{id}")
    Discount getDiscount(@PathVariable Integer id) throws DiscountException {
        return discountService.findById(id)
                .orElseThrow(() -> new DiscountException("Discount not found"));
    }

    @PutMapping("/discounts")
    Discount updateDiscount(@RequestBody Discount newDiscount) {
        return discountService.update(newDiscount);
    }

    @DeleteMapping("/discounts/{id}")
    void deleteDiscount(@PathVariable Integer id) {
        discountService.deleteById(id);
    }
}

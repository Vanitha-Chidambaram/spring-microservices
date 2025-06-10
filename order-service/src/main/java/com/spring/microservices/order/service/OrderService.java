package com.spring.microservices.order.service;

import com.spring.microservices.product.dto.ProductRequest;
import com.spring.microservices.product.model.Product;
import com.spring.microservices.product.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepo productRepo;

    public String createProduct(ProductRequest request) {
        log.debug("Creating Product in Service ....");
        Product product = Product.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .price(request.getPrice())
                                .build();
        productRepo.save(product);
        log.info("Product {} is created!!"+ product.getName());
        return "Product successfully created";
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}

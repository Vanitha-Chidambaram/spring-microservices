package com.spring.microservices.order.controller;

import com.spring.microservices.product.dto.ProductRequest;
import com.spring.microservices.product.model.Product;
import com.spring.microservices.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody ProductRequest request){
        log.debug("Creating Product ....");
        return productService.createProduct(request);

    }
    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}

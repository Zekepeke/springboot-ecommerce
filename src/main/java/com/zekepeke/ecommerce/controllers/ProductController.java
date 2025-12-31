package com.zekepeke.ecommerce.controllers;


import com.zekepeke.ecommerce.mappers.ProductMapper;
import com.zekepeke.ecommerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;



}

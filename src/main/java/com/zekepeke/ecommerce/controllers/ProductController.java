package com.zekepeke.ecommerce.controllers;


import com.zekepeke.ecommerce.dtos.ProductDto;
import com.zekepeke.ecommerce.dtos.RegisterProductRequest;
import com.zekepeke.ecommerce.entities.Product;
import com.zekepeke.ecommerce.mappers.ProductMapper;
import com.zekepeke.ecommerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, defaultValue = "", name = "categoryId") Byte categoryId
    ) {
        List<Product> products;

        // There are 3 queries when fetching without param as Hibernate does not join
        // Can optimize by using a join to fetch all the products and the categories
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategoru();
        }
       return products.stream().map(productMapper::toDto).toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getUser(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody RegisterProductRequest productRequest,
            UriComponentsBuilder uriBuilder
            ) {
        var product = productMapper.toEntity(productRequest);
        productRepository.save(product);
        var productDto = productMapper.toDto(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();

        return ResponseEntity.created(uri).body(productDto);
    }
}

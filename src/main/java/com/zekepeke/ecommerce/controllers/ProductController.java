package com.zekepeke.ecommerce.controllers;


import com.zekepeke.ecommerce.dtos.ProductDto;
import com.zekepeke.ecommerce.dtos.UserDto;
import com.zekepeke.ecommerce.mappers.ProductMapper;
import com.zekepeke.ecommerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @GetMapping
    public ResponseEntity<ProductDto> getAllProducts(
            @RequestParam(required = false, defaultValue = "", name = "sort") String id
    ) {
        if (id == null || id.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        // try parsing
        long parsedId;
        try {
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            return ResponseEntity.badRequest().build();
        }

        var user = productRepository.findById(parsedId).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productMapper.toDto(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getUser(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}

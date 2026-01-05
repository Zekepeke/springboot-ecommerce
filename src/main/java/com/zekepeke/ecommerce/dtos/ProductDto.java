package com.zekepeke.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.zekepeke.ecommerce.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryId;
}

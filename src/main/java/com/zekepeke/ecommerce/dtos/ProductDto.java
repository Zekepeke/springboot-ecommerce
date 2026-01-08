package com.zekepeke.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.zekepeke.ecommerce.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryId;
}

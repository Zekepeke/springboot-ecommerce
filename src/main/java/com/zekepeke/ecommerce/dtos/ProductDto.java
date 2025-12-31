package com.zekepeke.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.zekepeke.ecommerce.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
}

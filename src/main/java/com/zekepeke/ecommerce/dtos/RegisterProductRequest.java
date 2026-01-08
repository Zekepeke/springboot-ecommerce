package com.zekepeke.ecommerce.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisterProductRequest {
    String name;
    String description;
    BigDecimal price;
    Byte categoryId;
}

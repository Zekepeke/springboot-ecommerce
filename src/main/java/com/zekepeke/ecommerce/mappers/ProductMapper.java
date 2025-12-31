package com.zekepeke.ecommerce.mappers;

import com.zekepeke.ecommerce.dtos.ProductDto;
import com.zekepeke.ecommerce.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);
}

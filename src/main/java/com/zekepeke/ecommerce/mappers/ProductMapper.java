package com.zekepeke.ecommerce.mappers;

import com.zekepeke.ecommerce.dtos.ProductDto;
import com.zekepeke.ecommerce.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(
            target = "categoryId",
            source = "category.id"
    )
    ProductDto toDto(Product product);
}

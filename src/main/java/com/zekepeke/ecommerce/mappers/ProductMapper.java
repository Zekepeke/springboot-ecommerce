package com.zekepeke.ecommerce.mappers;

import com.zekepeke.ecommerce.dtos.ProductDto;
import com.zekepeke.ecommerce.dtos.RegisterProductRequest;
import com.zekepeke.ecommerce.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(
            target = "categoryId",
            source = "category.id"
    )
    ProductDto toDto(Product product);
//    Product toEntity(RegisterProductRequest request);
    Product toEntity(ProductDto request);
    void update(ProductDto update, @MappingTarget Product product);
}

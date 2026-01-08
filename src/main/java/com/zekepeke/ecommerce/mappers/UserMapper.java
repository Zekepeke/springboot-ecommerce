package com.zekepeke.ecommerce.mappers;

import com.zekepeke.ecommerce.dtos.RegisterUserRequest;
import com.zekepeke.ecommerce.dtos.UpdateUserRequest;
import com.zekepeke.ecommerce.dtos.UserDto;
import com.zekepeke.ecommerce.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(
            target = "createdAt",
            expression = "java(java.time.LocalDateTime.now())"
    )
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest update, @MappingTarget User user);
}

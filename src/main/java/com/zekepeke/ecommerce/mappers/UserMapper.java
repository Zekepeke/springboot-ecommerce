package com.zekepeke.ecommerce.mappers;

import com.zekepeke.ecommerce.dtos.UserDto;
import com.zekepeke.ecommerce.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}

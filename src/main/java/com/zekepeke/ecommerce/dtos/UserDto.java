package com.zekepeke.ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@AllArgsConstructor
// Need getter so spring can read the data from DTO and create json objects
@Getter
// Using Data transfer objects
public class UserDto {
    private Long id;
    private String name;
    private String email;
    // Not part of the user object but a custom attribute
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;


}

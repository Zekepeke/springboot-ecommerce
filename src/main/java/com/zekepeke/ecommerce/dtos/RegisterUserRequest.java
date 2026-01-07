package com.zekepeke.ecommerce.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// the same as doing the @Getter and @Setter
// Also combines toString, toHashCode
@Data
public class RegisterUserRequest {
    String name;
    String email;
    String password;
}

package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

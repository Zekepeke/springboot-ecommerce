package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();

    @Query("SELECT u.name FROM User u")
    List<String> findAllUsers();

}

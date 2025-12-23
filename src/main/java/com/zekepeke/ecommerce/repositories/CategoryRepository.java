package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
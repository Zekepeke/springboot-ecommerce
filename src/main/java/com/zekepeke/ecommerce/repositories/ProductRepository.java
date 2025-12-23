package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
   List<Product> findByCategoryId(Byte categoryId);

   @Query("SELECT p FROM Product p JOIN FETCH p.category")
   List<Product> findAllWithCategoru();
}
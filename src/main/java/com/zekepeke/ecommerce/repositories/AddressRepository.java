package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
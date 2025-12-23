package com.zekepeke.ecommerce.repositories;

import com.zekepeke.ecommerce.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
package com.example.mostgenericappwithapis.repositories;

import com.example.mostgenericappwithapis.entity.GenericEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface GenericRepository extends ReactiveCrudRepository<GenericEntity, Long> {
}

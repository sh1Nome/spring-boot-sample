package com.example.sample.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.sample.entity.Hello;

public interface HelloCrudRepository extends CrudRepository<Hello, Integer> {
    
}

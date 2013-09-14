package com.c360.api.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.c360.api.domain.product.Product;

public interface ProductRepository extends GraphRepository<Product> {

}

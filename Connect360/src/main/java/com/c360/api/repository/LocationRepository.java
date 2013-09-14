package com.c360.api.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.c360.api.domain.location.Location;

public interface LocationRepository extends GraphRepository<Location>{

}

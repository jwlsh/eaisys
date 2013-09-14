package com.c360.api.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.c360.api.domain.party.Organization;

public interface OrganizationRepository extends GraphRepository<Organization>{

}

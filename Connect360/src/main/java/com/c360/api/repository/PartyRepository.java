package com.c360.api.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

import com.c360.api.domain.party.Organization;
import com.c360.api.domain.party.Party;
import com.c360.api.domain.party.Person;

public interface PartyRepository extends GraphRepository<Party>{

	@Query("start party=node:Party(partyId={0}) return party")
	public Party findByPartyId( String partyId );
	
	@Query("start person=node:Person(ssn={0}) return person")
	public Person findBySSN( String partyId );
	
	@Query("start org=node:Organization(taxId={0}) return org")
	public Organization findByTaxID( String taxId );
	
}

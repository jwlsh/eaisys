package com.c360.api.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.c360.api.domain.contract.Contract;

public interface ContractRepository  extends GraphRepository<Contract> {
	
	@Query("start contract=node:Contract(contractId={0}) return contract")
	public Contract findByContractId( String contractId );
	
}

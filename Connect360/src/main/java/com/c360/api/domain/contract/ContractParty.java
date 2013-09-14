package com.c360.api.domain.contract;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

import com.c360.api.domain.BaseEntity;
import com.c360.api.domain.party.Party;

@RelationshipEntity
public class ContractParty extends BaseEntity {
	
	@StartNode private Party party;
	@EndNode private Contract contract;
	@RelationshipType private String role;
	private Date startDate;
	private Date endDate;
	
	public ContractParty(){}
	
	public ContractParty(Party party, Contract contract, String role) {
		super();
		this.party = party;
		this.contract = contract;
		this.role = role;
	}
	
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

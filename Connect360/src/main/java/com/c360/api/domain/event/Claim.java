package com.c360.api.domain.event;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;
import com.c360.api.domain.contract.ContractParty;
import com.c360.api.domain.party.Party;

@NodeEntity
public class Claim extends BaseEntity {
	
	@Indexed String claimNumber;
	ContractParty member;
	@RelatedTo(type="SUBMITTER") Party submitter;
	@RelatedTo(type="BILLING_PROVIDER") Party biller;
	@Indexed String typeOfClaim;
	
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public ContractParty getMember() {
		return member;
	}
	public void setMember(ContractParty member) {
		this.member = member;
	}
	public String getTypeOfClaim() {
		return typeOfClaim;
	}
	public void setTypeOfClaim(String typeOfClaim) {
		this.typeOfClaim = typeOfClaim;
	}	
}

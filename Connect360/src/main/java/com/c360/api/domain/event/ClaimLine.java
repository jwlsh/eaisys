package com.c360.api.domain.event;

import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;
import com.c360.api.domain.party.Party;

public class ClaimLine extends BaseEntity {
	
	Claim claim;
	Double amount;
	@RelatedTo(type="RENDERING_PROVIDER") Party renderer;
	
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}		

}

package com.c360.api.controller;

import org.springframework.hateoas.ResourceSupport;

import com.c360.api.domain.party.Party;


public class PartyResource extends ResourceSupport {
	
	private Party party;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}	

}

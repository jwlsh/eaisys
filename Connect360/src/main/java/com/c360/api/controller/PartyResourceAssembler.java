package com.c360.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.c360.api.domain.party.Party;

public class PartyResourceAssembler extends ResourceAssemblerSupport<Party, PartyResource> {

	public PartyResourceAssembler() {
		super(PartyController.class, PartyResource.class);
	}

	public PartyResource toResource(Party party) {
		PartyResource to = toResource(party);		
		to.setParty(party);
		return to;
	}
	
	public List<PartyResource> toResources( List<Party> products ) {
		
		List<PartyResource> prList = new ArrayList<PartyResource>();
		
		for(Party p : products ) {
			PartyResource pr = toResource( p );
			prList.add( pr );
		}		
		return prList;		
	}
}

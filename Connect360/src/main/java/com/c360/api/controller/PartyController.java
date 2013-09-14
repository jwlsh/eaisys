package com.c360.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.c360.api.domain.party.Party;
import com.c360.api.repository.PartyRepository;

@Controller
@RequestMapping("api/party")
public class PartyController {
	
	@Autowired
	PartyRepository partyRepository;
	
	//@Autowired
	private EntityLinks entityLinks;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Resources<PartyResource>> list() {
	
		PartyResourceAssembler assembler = new PartyResourceAssembler();
		
		EndResult<Party> parties = partyRepository.findAll();
		
		List<PartyResource> resourceList = assembler.toResources(parties);
		
		Resources<PartyResource> resources = new Resources<PartyResource>(resourceList);	
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
		
	}

}

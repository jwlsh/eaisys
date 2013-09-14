package com.c360.api.domain.location;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

import com.c360.api.domain.party.Party;

@RelationshipEntity
public class ContactPoint {
	@GraphId private Long id;
	@StartNode private Party party;
	@EndNode private Location location;
	@RelationshipType private String type;
		
	public ContactPoint(Party party, Location location, String type) {
		super();
		this.party = party;
		this.location = location;
		this.type = type;
	}
	
	public ContactPoint(){}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}

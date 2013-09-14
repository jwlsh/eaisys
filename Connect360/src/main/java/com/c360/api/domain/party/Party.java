package com.c360.api.domain.party;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import com.c360.api.domain.location.ContactPoint;
import com.c360.api.domain.location.Location;

@NodeEntity
public abstract class Party {
	
	@GraphId private Long id;
	@Indexed private String partyId;
	private Set<ContactPoint> contactPoints;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getPartyId() {
		return partyId;
	}	
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}	
	public void contactAt(Location location, String type, String name ) {		
		contactPoints.add( new ContactPoint(this, location, type) );		
	}	
	public Set<ContactPoint> getContactPoints() {
		return contactPoints;
	}
	public void setContactPoints(Set<ContactPoint> contactPoints) {
		this.contactPoints = contactPoints;
	}
}

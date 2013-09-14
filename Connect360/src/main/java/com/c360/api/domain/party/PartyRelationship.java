package com.c360.api.domain.party;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity
public class PartyRelationship {

	@GraphId private Long id;
	@StartNode private Party fromParty;
	@EndNode private Party toParty;
	@RelationshipType private String type;
	private Date startDate;
	private Date endDate;
	
	public PartyRelationship(){}	
	
	public PartyRelationship(Party fromParty, Party toParty, String type) {
		super();
		this.fromParty = fromParty;
		this.toParty = toParty;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Party getFromParty() {
		return fromParty;
	}
	public void setFromParty(Party fromParty) {
		this.fromParty = fromParty;
	}
	public Party getToParty() {
		return toParty;
	}
	public void setToParty(Party toParty) {
		this.toParty = toParty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

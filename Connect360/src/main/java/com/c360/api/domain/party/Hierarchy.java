package com.c360.api.domain.party;

import java.util.Date;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Hierarchy {
	@GraphId private Long id;
	@Indexed private String type;
	private Party parent;
	private Date startDate;
	private Date endDate;
	private Set<Party> children;
	
	public Hierarchy(){}
	
	public Hierarchy(String type) {
		super();
		this.type = type;
	}
	
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
	public Party getParent() {
		return parent;
	}
	public void setParent(Party parent) {
		this.parent = parent;
	}	
	public Set<Party> getChildren() {
		return children;
	}
	public void setChildren(Set<Party> children) {
		this.children = children;
	}
	public void addChild(Party party){
		this.children.add(party);
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

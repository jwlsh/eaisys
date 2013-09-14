package com.c360.api.domain.party;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Group {
	@GraphId private Long id;
	@Indexed private String type;
	private Date startDate;
	private Date endDate;
	private Set<GroupMember> members;  
	
	public Group(){
		this.members = new HashSet<GroupMember>();
	}
	
	public Group(String type) {
		super();
		this.members = new HashSet<GroupMember>();
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
	public Set<GroupMember> getMembers() {
		return members;
	}
	public void setMembers(Set<GroupMember> members) {
		this.members = members;
	}
	public void addMember(GroupMember member){
		this.members.add(member);
	}
	
}

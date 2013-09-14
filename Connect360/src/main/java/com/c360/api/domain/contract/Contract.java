package com.c360.api.domain.contract;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;

@NodeEntity
public class Contract extends BaseEntity {
	
	@Indexed private String contractId;
	@Indexed private String contractType;
	private Date startDate;
	private Date endDate;
	@Fetch @RelatedTo(type = "PROVIDES")
	private Set<ContractComponent> components;
	
	public Contract(){
		components = new HashSet<ContractComponent>();
	}	
	
	public Contract(String contractType) {
		super();
		this.contractType = contractType;
		components = new HashSet<ContractComponent>();
	}
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
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
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Set<ContractComponent> getComponents() {
		return components;
	}

	public void setComponents(Set<ContractComponent> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", contractId=" + contractId
				+ ", contractType=" + contractType + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}		
	
	
}

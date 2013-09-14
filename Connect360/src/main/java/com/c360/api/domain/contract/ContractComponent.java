package com.c360.api.domain.contract;

import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;

@NodeEntity
public class ContractComponent extends BaseEntity {
	
	@RelatedTo(type = "PROVIDED_BY")
	private Contract contract;
	@Indexed private String componentType;
	private Date startDate;
	private Date endDate;
	
	public ContractComponent(){}	
	
	public ContractComponent(Contract contract, String componentType) {
		super();
		this.contract = contract;
		this.componentType = componentType;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
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

	@Override
	public String toString() {
		return "ContractComponent [id=" + id + ", contract=" + contract
				+ ", componentType=" + componentType + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}	
	
	

}

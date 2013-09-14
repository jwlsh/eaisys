package com.c360.api.domain.event;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.contract.Contract;
import com.c360.api.domain.contract.ContractComponent;
import com.c360.api.domain.party.Party;

@NodeEntity
public class Accumulator {

	@GraphId private Long id;
	@Indexed private String type;
	@RelatedTo(type="TRACKS_USAGE_BY", direction=Direction.OUTGOING) private Party party;
	@RelatedTo(type="TRACKS_USAGE_ACROSS", direction=Direction.OUTGOING) private Contract contract;
	@RelatedTo(type="TRACKS_USAGE_OF", direction=Direction.OUTGOING) private ContractComponent component;
	private Double current;
	private Double max;
	
	public Accumulator(){
		super();
	}
	
	public Accumulator(String type, Party party, Contract contract, ContractComponent component,
			Double max) {
		super();
		this.type = type;
		this.party = party;
		this.contract = contract;
		this.component = component;
		this.max = max;	
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
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ContractComponent getComponent() {
		return component;
	}
	public void setComponent(ContractComponent component) {
		this.component = component;
	}
	public Double getCurrent() {
		return current;
	}
	public void setCurrent(Double current) {
		this.current = current;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
		
}

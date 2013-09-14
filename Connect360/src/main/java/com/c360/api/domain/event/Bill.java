package com.c360.api.domain.event;

import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;
import com.c360.api.domain.party.Party;

public class Bill extends BaseEntity {

	private Party billingParty;
	private Party billedParty;
	@Fetch @RelatedTo(type = "BILL_LINE_ITEM")
	private Set<BillLineItem> lineItems;
	private Double totalAmount;
	
	public Party getBillingParty() {
		return billingParty;
	}
	public void setBillingParty(Party billingParty) {
		this.billingParty = billingParty;
	}
	public Party getBilledParty() {
		return billedParty;
	}
	public void setBilledParty(Party billedParty) {
		this.billedParty = billedParty;
	}
	public Set<BillLineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<BillLineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}

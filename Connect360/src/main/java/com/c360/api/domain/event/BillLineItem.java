package com.c360.api.domain.event;

import com.c360.api.domain.BaseEntity;

public class BillLineItem extends BaseEntity {

	private Bill bill;
	private Double amount;
	private String description;
	
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}

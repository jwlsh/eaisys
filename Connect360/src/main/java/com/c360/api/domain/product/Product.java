package com.c360.api.domain.product;

import java.util.Date;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.c360.api.domain.BaseEntity;

public class Product extends BaseEntity {
	
	@Indexed private String name;
	@Indexed private String code;
	@Indexed private String typeOfProduct;	
	private Date startDate;
	private Date endDate;
	@Fetch @RelatedTo(type = "PRODUCT_COMPONENT")
	private Set<ProductComponent> components;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfProduct() {
		return typeOfProduct;
	}
	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Set<ProductComponent> getComponents() {
		return components;
	}
	public void setComponents(Set<ProductComponent> components) {
		this.components = components;
	}
		

}

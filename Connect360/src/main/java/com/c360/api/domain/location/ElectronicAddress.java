package com.c360.api.domain.location;

import org.springframework.data.neo4j.annotation.Indexed;


public class ElectronicAddress extends Location {
	
	@Indexed private String type;
	@Indexed private String url;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

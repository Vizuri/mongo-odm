package com.vizuri.mongo.odm.hibernateogm.model;

import java.math.BigDecimal;

public class Product {

	private String sku;
	private String description;
	private BigDecimal listPrice;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getListPrice() {
		return listPrice;
	}
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}
}

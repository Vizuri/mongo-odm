package com.vizuri.mongo.odm.morphia.model;

import java.math.BigDecimal;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;
import com.vizuri.mongo.odm.morphia.util.BigDecimalConverter;

@Entity
@Converters({BigDecimalConverter.class})
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Indexed(value=IndexDirection.ASC, name="sku", unique=true, dropDups=true, background = false)
	private String sku;
	private String description;
	
	// All monetary amounts represent USD in cents
	private BigDecimal list; 
	private BigDecimal cost;
	private BigDecimal threeYearList;
	private BigDecimal threeYearCost;
	
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
	public BigDecimal getList() {
		return list;
	}
	public void setList(BigDecimal list) {
		this.list = list;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getThreeYearList() {
		return threeYearList;
	}
	public void setThreeYearList(BigDecimal threeYearList) {
		this.threeYearList = threeYearList;
	}
	public BigDecimal getThreeYearCost() {
		return threeYearCost;
	}
	public void setThreeYearCost(BigDecimal threeYearCost) {
		this.threeYearCost = threeYearCost;
	}
	@Override
	public String toString() {
		return "Product [sku=" + sku + ", description=" + description
				+ ", list=" + list + ", cost=" + cost + ", threeYearList="
				+ threeYearList + ", threeYearCost=" + threeYearCost + "]";
	}

	
	
}

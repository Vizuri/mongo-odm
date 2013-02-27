package com.vizuri.mongo.odm.hibernateogm.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class LineItem {

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Product product;
	private String customDescription;
	private BigDecimal proratedListPrice;
	private BigDecimal quotePrice;
	private Integer quantity;
	private BigDecimal priceFactorValue;
	
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCustomDescription() {
		return customDescription;
	}

	public void setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
	}

	public BigDecimal getProratedListPrice() {
		return proratedListPrice;
	}

	public void setProratedListPrice(BigDecimal proratedListPrice) {
		this.proratedListPrice = proratedListPrice;
	}

	public BigDecimal getQuotePrice() {
		return quotePrice;
	}

	public void setQuotePrice(BigDecimal quotePrice) {
		this.quotePrice = quotePrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPriceFactorValue() {
		return priceFactorValue;
	}

	public void setPriceFactorValue(BigDecimal priceFactorValue) {
		this.priceFactorValue = priceFactorValue;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	private BigDecimal cost;

}

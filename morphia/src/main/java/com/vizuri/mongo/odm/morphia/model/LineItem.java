package com.vizuri.mongo.odm.morphia.model;

import java.math.BigDecimal;

public class LineItem {

	private Product product;
	private String customDescription;
	private BigDecimal proratedListPrice;
	private BigDecimal quotePrice;
	private Integer quantity;
	private Enum<PriceFactor> priceFactor;
	private BigDecimal priceFactorValue;

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

	public Enum<PriceFactor> getPriceFactor() {
		return priceFactor;
	}

	public void setPriceFactor(Enum<PriceFactor> priceFactor) {
		this.priceFactor = priceFactor;
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

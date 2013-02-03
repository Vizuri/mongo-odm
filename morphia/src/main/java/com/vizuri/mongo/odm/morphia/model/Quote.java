package com.vizuri.mongo.odm.morphia.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Quote extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String quoteNumber;
	private String quoteVers;
	private List<LineItem> lineItems;
	private Date sentDate;
	private Date expireDate;
	private String rfQNum;
	private String shipping;
	private BigDecimal taxAmount;
	private String status;
	private Date lastModifiedDate;

	public String getQuoteVers() {
		return quoteVers;
	}

	public void setQuoteVers(String quoteVers) {
		this.quoteVers = quoteVers;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getRfQNum() {
		return rfQNum;
	}

	public void setRfQNum(String rfQNum) {
		this.rfQNum = rfQNum;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getQuoteNumber() {
		return quoteNumber;
	}

	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}

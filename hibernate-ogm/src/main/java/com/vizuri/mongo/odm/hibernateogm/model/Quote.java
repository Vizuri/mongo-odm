package com.vizuri.mongo.odm.hibernateogm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@XmlRootElement
@Indexed
@Proxy(lazy = false)
public class Quote {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Field
	private String quoteNumber;
	@Field
	private String quoteVers;
	
	private Date sentDate;
	private Date expireDate;
	private String rfQNum;
	private String shipping;
	private BigDecimal taxAmount;
	
	private String potentialId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<LineItem> lineItems;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuoteVers() {
		return quoteVers;
	}

	public void setQuoteVers(String quoteVers) {
		this.quoteVers = quoteVers;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
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
	
	public String getPotentialId() {
		return potentialId;
	}

	public void setPotentialId(String potentialId) {
		this.potentialId = potentialId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		/*result = prime * result
				+ ((lineItems == null) ? 0 : lineItems.hashCode());*/
		result = prime * result
				+ ((quoteNumber == null) ? 0 : quoteNumber.hashCode());
		result = prime * result
				+ ((quoteVers == null) ? 0 : quoteVers.hashCode());
		result = prime * result + ((rfQNum == null) ? 0 : rfQNum.hashCode());
		result = prime * result
				+ ((sentDate == null) ? 0 : sentDate.hashCode());
		result = prime * result
				+ ((shipping == null) ? 0 : shipping.hashCode());
		result = prime * result
				+ ((taxAmount == null) ? 0 : taxAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		/*if (lineItems == null) {
			if (other.lineItems != null)
				return false;
		} else if (!lineItems.equals(other.lineItems))
			return false;*/
		if (quoteNumber == null) {
			if (other.quoteNumber != null)
				return false;
		} else if (!quoteNumber.equals(other.quoteNumber))
			return false;
		if (quoteVers == null) {
			if (other.quoteVers != null)
				return false;
		} else if (!quoteVers.equals(other.quoteVers))
			return false;
		if (rfQNum == null) {
			if (other.rfQNum != null)
				return false;
		} else if (!rfQNum.equals(other.rfQNum))
			return false;
		if (sentDate == null) {
			if (other.sentDate != null)
				return false;
		} else if (!sentDate.equals(other.sentDate))
			return false;
		if (shipping == null) {
			if (other.shipping != null)
				return false;
		} else if (!shipping.equals(other.shipping))
			return false;
		if (taxAmount == null) {
			if (other.taxAmount != null)
				return false;
		} else if (!taxAmount.equals(other.taxAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", quoteNumber=" + quoteNumber
				+ ", quoteVers=" + quoteVers + ", lineItems=" //+ lineItems
				+ ", sentDate=" + sentDate + ", expireDate=" + expireDate
				+ ", rfQNum=" + rfQNum + ", shipping=" + shipping
				+ ", taxAmount=" + taxAmount + "]";
	}
}

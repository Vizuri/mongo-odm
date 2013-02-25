package com.vizuri.mongo.odm.hibernateogm.model;

import java.util.Set;

import com.vizuri.mongo.odm.hibernateogm.model.Contact;

public class Potential {
	
	private String accntName;
	private Contact contact;
	private	Set<Quote> quote;
	private String potentialName;
	private String potentialOwner;
	
	public String getAccntName() {
		return accntName;
	}

	public void setAccntName(String accntName) {
		this.accntName = accntName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Set<Quote> getQuote() {
		return quote;
	}

	public void setQuote(Set<Quote> quote) {
		this.quote = quote;
	}

	public String getPotentialName() {
		return potentialName;
	}

	public void setPotentialName(String potentialName) {
		this.potentialName = potentialName;
	}

	public String getPotentialOwner() {
		return potentialOwner;
	}

	public void setPotentialOwner(String potentialOwner) {
		this.potentialOwner = potentialOwner;
	
	}

	@Override
	public String toString() {
		return "Potential [accntName=" + accntName + ", contact=" + contact
				+ ", quote=" + quote + ", potentialName=" + potentialName
				+ ", potentialOwner=" + potentialOwner + "]";
	}
	
	

}

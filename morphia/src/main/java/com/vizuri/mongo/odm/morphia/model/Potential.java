package com.vizuri.mongo.odm.morphia.model;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Potential extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String crmPotId;
	private String accountName;
	private Contact contact;
	private String potentialName;
	private String potentialOwner;
	private String modifiedTime;
	private String crmContactId;
	
	public String getCrmPotId() {
		return crmPotId;
	}
	public void setCrmPotId(String crmPotId) {
		this.crmPotId = crmPotId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCrmContactId() {
		return crmContactId;
	}
	public void setCrmContactId(String crmContactId) {
		this.crmContactId = crmContactId;
	}
	
	@Override
	public String toString() {
		return "Potential [accountName=" + accountName + ", contact=" + contact
				+ ", potentialName=" + potentialName + ", potentialOwner="
				+ potentialOwner + ", modifiedTime=" + modifiedTime
				+ ", crmContactId=" + crmContactId + "crmPotentialId = "
				+ crmPotId + ", getId()=" + getId() + ", getVersion()="
				+ getVersion() + "]";
	}
	

}

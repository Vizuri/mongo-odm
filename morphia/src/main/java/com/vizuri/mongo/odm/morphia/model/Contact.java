package com.vizuri.mongo.odm.morphia.model;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Contact extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String title;
	private String phone;
	private String mobilePhone;
	private String email;
	private String fax;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String lastModifiedTime;
	private String crmContactId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public String getCrmContactId() {
		return crmContactId;
	}
	public void setCrmContactId(String crmContactId) {
		this.crmContactId = crmContactId;
	}
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName
				+ ", title=" + title + ", phone=" + phone + ", email=" + email
				+ ", fax=" + fax + ", street1=" + street1 + ", street2="
				+ street2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + ", last modified=" + lastModifiedTime
				+ ", crmContactId=" + crmContactId + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + "]";
	}


}

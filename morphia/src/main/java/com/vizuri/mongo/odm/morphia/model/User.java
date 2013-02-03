package com.vizuri.mongo.odm.morphia.model;

import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;

@Entity
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String name;
	@Indexed(value=IndexDirection.ASC, name="email", unique=true, dropDups=false, background = false)
	private String email;
	private String password;
	private String crmAuthToken;
	private List<String> roles;
	private String title;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCrmAuthToken() {
		return crmAuthToken;
	}
	public void setCrmAuthToken(String crmAuthToken) {
		this.crmAuthToken = crmAuthToken;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
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
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password="
				+ password + ", crmAuthToken=" + crmAuthToken + ", roles="
				+ roles + ", title=" + title + ", phone=" + phone
				+ ", getId()=" + getId() + ", getVersion()=" + getVersion()
				+ "]";
	}
	
	
}

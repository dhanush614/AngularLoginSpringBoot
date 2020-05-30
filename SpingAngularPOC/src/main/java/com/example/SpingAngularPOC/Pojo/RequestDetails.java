package com.example.SpingAngularPOC.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestDetails {

	@Id
	private String username;
	private String email;
	private String mobile;

	public RequestDetails() {
		super();
	}

	public RequestDetails(String username, String email, String mobile) {
		super();
		this.username = username;
		this.email = email;
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "RequestDetails [username=" + username + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
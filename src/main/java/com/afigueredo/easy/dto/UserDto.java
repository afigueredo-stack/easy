package com.afigueredo.easy.dto;

import com.afigueredo.easy.entity.Parameter;

public class UserDto {
	
	private Long id;
	private String username;
	private String email;
	private String phone;
	private String fullname;
	private String password;
	private Parameter idParameter;
	
	public UserDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Parameter getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(Parameter idParameter) {
		this.idParameter = idParameter;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", fullname="
				+ fullname + ", password=" + password + ", idParameter=" + idParameter + "]";
	}
	
	
	
}

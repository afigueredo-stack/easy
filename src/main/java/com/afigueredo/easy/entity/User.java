package com.afigueredo.easy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class User implements Serializable {
	
	private static final long serialVersionUID = 7641006110435758780L;
	
	private Long id;
	private String username;
	private String email;
	private String phone;
	private String fullname;
	private String password;
	private Parameter parameter;
	private Date dateCreation;
	private Date dateUpdate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	@Id	
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "fullname", nullable = false)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	@Column(name = "date_creation", nullable = false)
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	@Column(name = "date_update", nullable = false)
	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
	@PreUpdate
	public void preUpdate() {
		dateUpdate = new Date();
	}
	
	@PrePersist
	public void PrePersist() {
		final Date currentDate = new Date();
		dateCreation = currentDate;
		dateUpdate = currentDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", fullname="
				+ fullname + ", password=" + password + ", idParameter=" + parameter + "]";
	}

	
}

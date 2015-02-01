package com.jmango360.server.core.components.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jmango360.server.model.MobileAccount;

@Entity(name="ra_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 5334663508635491543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "ACTIVATED")
	private boolean activated = false;

	@Column(name = "ACTIVATION_CODE")
	private String activationCode;

	@Column(name = "PASSWORD_EXPIRED")
	private boolean passwordExpired = false;

	public User() {
		this.username = "";
		this.password = "";
		this.email = "";
		this.firstName = "";
		this.lastName = "";
		activationCode = UUID.randomUUID().toString();
	}

	public User(String username, String password, String email,
			String firstName, String lastName) {

		this.username = username.toLowerCase().trim();
		this.password = password;
		this.email = email.toLowerCase().trim();
		this.firstName = firstName;
		this.lastName = lastName;

		activationCode = UUID.randomUUID().toString();
	}
	
	public User(MobileAccount mobileAccount) {
		this.username = mobileAccount.getUsername();
		this.password = mobileAccount.getPassword();
		this.email = mobileAccount.getEmail().toLowerCase().trim();
		this.firstName = mobileAccount.getFirstName();
		this.lastName = mobileAccount.getLastName();
		
		activationCode = UUID.randomUUID().toString();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public boolean isPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

}

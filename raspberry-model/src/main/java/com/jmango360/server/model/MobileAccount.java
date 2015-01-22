package com.jmango360.server.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The classification for a mobile account", description = "Defines a specific classification for mobile account", discriminator = "", subTypes = MobileAccountAddress.class)
public class MobileAccount {

	@ApiModelProperty(value = "The unique username for the account", notes = "This value correlates to the primary key", required = true)
	private String username;

	@ApiModelProperty(value = "The password of the account", notes = "Password will be sent in plain text", required = true)
	private String password;

	@ApiModelProperty(value = "The type of the account. Please check MobileUserType class for details", notes = "This value could be 'facebook', 'twitter', 'paypal', 'local' or 'magento'.", required = true)
	private String userType;

	@ApiModelProperty(value = "First name of the account", notes = "If only label 'name' available for entered, please filled in this field", required = false)
	private String firstName;

	@ApiModelProperty(value = "Last name of the account", notes = "Mobile can use 'first name' field as for both first & last name", required = false)
	private String lastName;

	@ApiModelProperty(value = "The email address of the account", notes = "If username type is email address, then username and email field must be identical", required = false)
	private String email;

	@ApiModelProperty(value = "The mobile number of the account", notes = "If username type is mobile number, then username and mobile field must be identical", required = false)
	private String mobile;

	@ApiModelProperty(value = "The addresses that associated with the account", notes = "", required = false)
	private List<MobileAccountAddress> accountAddresses;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public List<MobileAccountAddress> getAccountAddresses() {
		return accountAddresses;
	}

	public void setAccountAddresses(List<MobileAccountAddress> accountAddresses) {
		this.accountAddresses = accountAddresses;
	}

}

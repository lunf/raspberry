package com.jmango360.server.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The classification for a mobile account's address", description = "Defines a specific classification for mobile account's address", discriminator = "")
public class MobileAccountAddress {

	@ApiModelProperty(value = "The unique ID for the address", notes = "This value correlates to the primary key", required = false)
	private String id;

	@ApiModelProperty(value = "The phone number for the address", notes = "This value could be mobile or landline number and will be validated if entered", required = false)
	private String contactNumber;

	@ApiModelProperty(value = "The email address of the address owner", notes = "This value will be validated if entered", required = false)
	private String email;

	@ApiModelProperty(value = "First name of the address owner", notes = "If only label 'name' available for entered, please filled in this field", required = false)
	private String firstName;

	@ApiModelProperty(value = "Last name of the address owner", notes = "Mobile can use 'first name' field as for both first & last name", required = false)
	private String lastName;

	@ApiModelProperty(value = "The street number and street name of the address", notes = "This field should not be shorter than 5 characters", required = true)
	private String streetAddress;

	@ApiModelProperty(value = "Suburb or district of the address", notes = "", required = false)
	private String suburb;

	@ApiModelProperty(value = "Postcode or zipcode of the address", notes = "", required = true)
	private String postCode;

	@ApiModelProperty(value = "The state or county", notes = "", required = false)
	private String state;

	@ApiModelProperty(value = "The country of the address", notes = "", required = true)
	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

package com.jmango360.server.model;

/**
 * Define the mobile user type when they register an account with the system
 * 
 * @author alexandra
 *
 */
public enum MobileUserType {

	FACEBOOK("facebook"), TWITTER("twitter"), PAYPAL("paypal"), JMANGO360(
			"local"), MAGENTO("magento");

	private final String text;

	private MobileUserType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}

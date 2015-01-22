package com.jmango360.server.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The classification for a mobile device", description = "Defines a specific classification for mobile device", discriminator = "")
public class MobileDevice {

	@ApiModelProperty(value = "The app build number which is installed on the device", notes = "", required = true)
	private String appBuildNumber;

	@ApiModelProperty(value = "The app version number which is installed on the device", notes = "", required = true)
	private String appVersion;

	@ApiModelProperty(value = "The unique device token for remote push notification", notes = "", required = false)
	private String pushMessageDeviceRegistration;

	@ApiModelProperty(value = "The OS version of the device", notes = "", required = true)
	private String osVersion;

	@ApiModelProperty(value = "The manufacture of the device", notes = "", required = true)
	private String manufacturer;

	@ApiModelProperty(value = "The model of the device", notes = "", required = true)
	private String model;

	public String getAppBuildNumber() {
		return appBuildNumber;
	}

	public void setAppBuildNumber(String appBuildNumber) {
		this.appBuildNumber = appBuildNumber;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getPushMessageDeviceRegistration() {
		return pushMessageDeviceRegistration;
	}

	public void setPushMessageDeviceRegistration(
			String pushMessageDeviceRegistration) {
		this.pushMessageDeviceRegistration = pushMessageDeviceRegistration;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

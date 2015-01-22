package com.jmango360.server.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The classification for a JAM application", description = "Defines a specific classification for a JM application", discriminator = "")
public class JmApplication {
	@ApiModelProperty(value = "Name of the JM application", notes = "This value also AppStore", required = true)
	private String name;
	
	@ApiModelProperty(value = "Image of the JM application", notes = "This is the logo of the application", required = true)
	private String image;
	
	@ApiModelProperty(value = "Key of the JM application", notes = "This value correlates to the primary key", required = true)
	private String appKey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

}

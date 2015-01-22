package com.jmango360.server.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "JmError", description = "Information pertaining to any errors that might have occurred during a request or processing.")
public class JmError {

	@ApiModelProperty(dataType = "int", required = true, notes = "The error identification generated for this event.")
	private int code;

	@ApiModelProperty(dataType = "string", required = true, allowableValues = "200,400,403,500", notes = "The HTTP status code for the response")
	private String httpStatusCode = "200";

	@ApiModelProperty(dataType = "string", required = false, notes = "Description of the problem for the app developer.")
	private String developerMessage;

	@ApiModelProperty(dataType = "string", required = false, notes = "General message to pass on to the app user.")
	private String userMessage;

	@ApiModelProperty(dataType = "string", required = false, notes = "Additional information")
	private String moreInfo;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
}

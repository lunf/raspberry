package com.jmango360.server.core.components.entities;

import java.util.Date;

import javax.persistence.Id;

public class TaxiLocation {

	@Id
	private String id;

	private String taxiNumber;

	private String taxiId;

	private String driverName;

	private String driverId;

	private double[] position;

	private String jobRef;

	private Date timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public String getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public String getJobRef() {
		return jobRef;
	}

	public void setJobRef(String jobRef) {
		this.jobRef = jobRef;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}

package com.jmango360.server.core.components.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * This is base class for all entities in the system
 * 
 * @author alexandra
 *
 */
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -414961482664042469L;

	private Date createDate;

	private Date lastUpdate;

	private String changedBy;

	private String uuid;

	private int version = 0;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getUuid() {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

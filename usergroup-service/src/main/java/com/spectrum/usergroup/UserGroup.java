package com.spectrum.usergroup;

import org.springframework.data.annotation.Id;

public class UserGroup {

	@Id
	public String id;

	public String name;
	public String createdDateTime;
	public String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", createdDateTime=" + createdDateTime + ", status=" + status
				+ "]";
	}

	public UserGroup(String id, String name, String createdDateTime, String status) {
		super();
		this.id = id;
		this.name = name;
		this.createdDateTime = createdDateTime;
		this.status = status;
	}

	public UserGroup(String name, String createdDateTime, String status) {
		super();
		this.name = name;
		this.createdDateTime = createdDateTime;
		this.status = status;
	}

}
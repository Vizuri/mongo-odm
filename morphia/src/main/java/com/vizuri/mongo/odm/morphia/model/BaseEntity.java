package com.vizuri.mongo.odm.morphia.model;

import java.io.Serializable;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Version;
import org.bson.types.ObjectId;

public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Property("id")
	protected ObjectId id;
	
	@Version
	@Property("version")
	private Long version;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
}

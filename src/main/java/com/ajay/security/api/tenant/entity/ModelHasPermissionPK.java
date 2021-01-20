package com.ajay.security.api.tenant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the model_has_permissions database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class ModelHasPermissionPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "permission_id", insertable = false, updatable = false)
	private String permissionId;

	@Column(name = "model_id")
	private String modelId;

	@Column(name = "model_type")
	private String modelType;

}
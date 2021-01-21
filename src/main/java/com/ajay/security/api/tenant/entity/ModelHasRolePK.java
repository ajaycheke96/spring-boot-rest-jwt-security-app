//package com.ajay.security.api.tenant.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
///**
// * The primary key class for the model_has_roles database table.
// * 
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Embeddable
//public class ModelHasRolePK implements Serializable {
//	// default serial version id, required for serializable classes.
//	private static final long serialVersionUID = 1L;
//
//	@Column(name = "role_id", insertable = false, updatable = false)
//	private Integer roleId;
//
//	@Column(name = "model_id")
//	private Integer modelId;
//
//	@Column(name = "model_type")
//	private String modelType;
//
//}
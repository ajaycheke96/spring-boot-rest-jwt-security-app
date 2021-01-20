//package com.ajay.security.api.tenant.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
///**
// * The persistent class for the model_has_permissions database table.
// * 
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//@Table(name = "model_has_permissions")
//@NamedQuery(name = "ModelHasPermission.findAll", query = "SELECT m FROM ModelHasPermission m")
//public class ModelHasPermission implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@EmbeddedId
//	private ModelHasPermissionPK id;
//
//	// bi-directional many-to-one association to Permission
//	@ManyToOne
//	private Permission permission;
//
//}
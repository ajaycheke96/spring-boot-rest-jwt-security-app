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
// * The persistent class for the model_has_roles database table.
// * 
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//@Table(name = "model_has_roles")
//@NamedQuery(name = "ModelHasRole.findAll", query = "SELECT m FROM ModelHasRole m")
//public class ModelHasRole implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@EmbeddedId
//	private ModelHasRolePK id;
//
//	// bi-directional many-to-one association to Role
//	@ManyToOne
//	private Role role;
//
//}
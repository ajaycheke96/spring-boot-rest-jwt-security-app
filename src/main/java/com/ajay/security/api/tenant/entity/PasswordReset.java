package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the password_resets database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "password_resets")
public class PasswordReset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Id
	private String email;

	private String token;

}
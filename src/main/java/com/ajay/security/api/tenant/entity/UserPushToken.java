package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the user_push_tokens database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_push_tokens")
public class UserPushToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "device_name")
	private String deviceName;

	@Column(length = 50)
	private String options;

	private String token;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}
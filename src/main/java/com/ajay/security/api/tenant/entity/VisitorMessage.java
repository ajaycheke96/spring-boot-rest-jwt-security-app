package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the visitor_messages database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "visitor_messages")
public class VisitorMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "contact_number", length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String email;

	@Column(length = 50)
	private String message;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String subject;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

}
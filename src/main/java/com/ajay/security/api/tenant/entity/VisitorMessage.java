package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private String id;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	private String email;

	@Lob
	private String message;

	private String name;

	@Lob
	private String options;

	@Lob
	private String subject;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

}
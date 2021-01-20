package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the email_logs database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "email_logs")
public class EmailLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Lob
	private String body;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "from_address")
	private String fromAddress;

	private String module;

	@Column(name = "module_id")
	private String moduleId;

	@Lob
	private String options;

	private String subject;

	@Column(name = "to_address")
	private String toAddress;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

}
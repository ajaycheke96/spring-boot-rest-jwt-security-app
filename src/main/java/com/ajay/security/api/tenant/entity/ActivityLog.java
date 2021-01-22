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
 * The persistent class for the activity_log database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "activity_log")
public class ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;
//	private BigInteger id;

	@Column(name = "causer_id")
	private int causerId;

	@Column(name = "causer_type",length = 20)
	private String causerType;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	@Column(length = 50)
	private String description;


	@Column(name = "log_name",length = 20)
	private String logName;

	@Lob
	@Column(length = 50)
	private String options;

	@Lob
	@Column(length = 50)
	private String properties;

	@Column(name = "subject_id")
	private int subjectId;

	@Column(name = "subject_type",length = 20)
	private String subjectType;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

}
package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transfer_certificates database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transfer_certificates")
public class TransferCertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_application")
	private Date dateOfApplication;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_issue")
	private Date dateOfIssue;

	@Column(length = 100)
	private String format;

	@Column(length = 100)
	private String memo;

	private int number;

	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private String prefix;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne
	@JoinColumn(name = "student_record_id")
	private StudentRecord studentRecord;

}
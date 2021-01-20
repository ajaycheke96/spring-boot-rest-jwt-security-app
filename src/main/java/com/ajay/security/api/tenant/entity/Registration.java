package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the registrations database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "registrations")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_registration")
	private Date dateOfRegistration;

	@Column(name = "is_online")
	private byte isOnline;

	@Column(length = 50)
	private String options;

	@Column(name = "registration_fee", length = 10)
	private int registrationFee;

	@Column(name = "registration_fee_status", length = 10)
	private String registrationFeeStatus;

	@Column(name = "registration_key", length = 20)
	private String registrationKey;

	@Lob
	@Column(name = "registration_remarks", length = 20)
	private String registrationRemarks;

	@Lob
	@Column(name = "rejection_remarks", length = 20)
	private String rejectionRemarks;

	private String status;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to Admission
	@OneToMany(mappedBy = "registration", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Admission> admissions;

	// bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course cours;

	// bi-directional many-to-one association to Institute
	@ManyToOne
	@JoinColumn(name = "previous_institute_id")
	private Institute institute;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "registration", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}
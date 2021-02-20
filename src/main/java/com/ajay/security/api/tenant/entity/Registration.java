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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the registrations database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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

	@Column(name = "registration_remarks", length = 20)
	private String registrationRemarks;

	@Column(name = "rejection_remarks", length = 20)
	private String rejectionRemarks;

	private String status;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

//	// bi-directional many-to-one association to Admission
//	@OneToMany(mappedBy = "registration")
//	private List<Admission> admissions;

	// bi-directional many-to-one association to Cours
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "course_id")
	private Course cours;

	// bi-directional many-to-one association to Institute
	@ManyToOne(targetEntity = Institute.class)
	@JoinColumn(name = "previous_institute_id")
	private Institute institute;

	// bi-directional many-to-one association to Student
	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id")
	private Student student;

//	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "registration")
//	private List<Transaction> transactions;

}
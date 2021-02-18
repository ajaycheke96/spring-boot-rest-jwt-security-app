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
 * The persistent class for the enquiry_details database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "enquiry_details")
public class EnquiryDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(length = 20)
	private String gender;

	@Column(name = "is_admitted")
	private byte isAdmitted;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String remarks;

	@Column(name = "student_name", length = 50)
	private String studentName;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to Cours
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "course_id")
	private Course cours;

//	// bi-directional many-to-one association to Enquiry
//	@ManyToOne
//	private Enquiry enquiry;

	// bi-directional many-to-one association to Institute
	@ManyToOne(targetEntity = Institute.class)
	@JoinColumn(name = "institute_id")
	private Institute institute;

}
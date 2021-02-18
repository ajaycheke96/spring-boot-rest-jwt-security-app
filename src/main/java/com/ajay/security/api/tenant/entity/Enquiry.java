package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the enquiries database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "enquiries")
public class Enquiry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "alternate_contact_number")
	private String alternateContactNumber;

	@Column(name = "contact_number", length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_enquiry")
	private Date dateOfEnquiry;

	@Column(length = 30)
	private String email;

	@Column(name = "first_guardian_name", length = 30)
	private String firstGuardianName;

	@Column(name = "first_guardian_relation", length = 20)
	private String firstGuardianRelation;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String remarks;

	@Column(name = "second_guardian_name", length = 30)
	private String secondGuardianName;

	@Column(name = "second_guardian_relation", length = 30)
	private String secondGuardianRelation;

	@Column(length = 20)
	private String status;

	@Column(name = "third_guardian_name", length = 30)
	private String thirdGuardianName;

	@Column(name = "third_guardian_relation", length = 30)
	private String thirdGuardianRelation;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to EnquirySource
	@ManyToOne(targetEntity = EnquirySource.class)
	@JoinColumn(name = "enquiry_source_id")
	private EnquirySource enquirySource;

	// bi-directional many-to-one association to EnquiryType
	@ManyToOne(targetEntity = EnquiryType.class)
	@JoinColumn(name = "enquiry_type_id")
	private EnquiryType enquiryType;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to EnquiryDetail
	@OneToMany(targetEntity = EnquiryDetail.class)
	@JoinColumn(name = "enquiry_id")
	private List<EnquiryDetail> enquiryDetails;

//	// bi-directional many-to-one association to EnquiryFollowUp
//	@OneToMany(mappedBy = "enquiry", targetEntity = EnquiryFollowUp.class)
//	@JoinColumn(name = "enquiry_id")
//	private List<EnquiryFollowUp> enquiryFollowUps;

}
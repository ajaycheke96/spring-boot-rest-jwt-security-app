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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the enquiries database table.
 * 
 */
@Data
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

	@Column(name = "contact_number",length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_enquiry")
	private Date dateOfEnquiry;

	@Column(length = 30)
	private String email;

	@Column(name = "first_guardian_name",length = 30)
	private String firstGuardianName;

	@Column(name = "first_guardian_relation",length = 20)
	private String firstGuardianRelation;
	
	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String remarks;

	@Column(name = "second_guardian_name",length = 30)
	private String secondGuardianName;

	@Column(name = "second_guardian_relation",length = 30)
	private String secondGuardianRelation;

	@Column(length = 20)
	private String status;

	@Column(name = "third_guardian_name",length = 30)
	private String thirdGuardianName;

	@Column(name = "third_guardian_relation",length = 30)
	private String thirdGuardianRelation;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to EnquirySource
	@ManyToOne
	@JoinColumn(name = "enquiry_source_id")
	private EnquirySource enquirySource;

	// bi-directional many-to-one association to EnquiryType
	@ManyToOne
	@JoinColumn(name = "enquiry_type_id")
	private EnquiryType enquiryType;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	// bi-directional many-to-one association to EnquiryDetail
	@OneToMany(mappedBy = "enquiry",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EnquiryDetail> enquiryDetails;

	// bi-directional many-to-one association to EnquiryFollowUp
	@OneToMany(mappedBy = "enquiry",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EnquiryFollowUp> enquiryFollowUps;

}
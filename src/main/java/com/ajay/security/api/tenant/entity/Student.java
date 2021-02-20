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
 * The persistent class for the students database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "birth_place", length = 20)
	private String birthPlace;

	@Column(name = "contact_number", length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(length = 50)
	private String email;

	@Column(name = "emergency_contact_name", length = 20)
	private String emergencyContactName;

	@Column(name = "emergency_contact_number", length = 20)
	private String emergencyContactNumber;

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(length = 20)
	private String gender;

	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(name = "middle_name", length = 20)
	private String middleName;

	@Column(name = "mother_tongue", length = 20)
	private String motherTongue;

	@Column(length = 20)
	private String nationality;

	@Column(length = 50)
	private String options;

	@Column(name = "permanent_address_line_1", length = 50)
	private String permanentAddressLine1;

	@Column(name = "permanent_address_line_2", length = 50)
	private String permanentAddressLine2;

	@Column(name = "permanent_city", length = 20)
	private String permanentCity;

	@Column(name = "permanent_country", length = 20)
	private String permanentCountry;

	@Column(name = "permanent_state", length = 20)
	private String permanentState;

	@Column(name = "permanent_zipcode", length = 20)
	private String permanentZipcode;

	@Column(name = "present_address_line_1", length = 50)
	private String presentAddressLine1;

	@Column(name = "present_address_line_2", length = 50)
	private String presentAddressLine2;

	@Column(name = "present_city", length = 20)
	private String presentCity;

	@Column(name = "present_country", length = 20)
	private String presentCountry;

	@Column(name = "present_state", length = 20)
	private String presentState;

	@Column(name = "present_zipcode", length = 20)
	private String presentZipcode;

	@Column(name = "same_as_present_address")
	private byte sameAsPresentAddress;

	@Column(name = "student_photo")
	private String studentPhoto;

	@Column(name = "unique_identification_number")
	private String uniqueIdentificationNumber;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to GatePass
//	@OneToMany(mappedBy = "student")
//	private List<GatePass> gatePasses;

//	// bi-directional many-to-one association to Registration
//	@OneToMany(mappedBy = "student")
//	private List<Registration> registrations;

//	// bi-directional many-to-one association to StockTransfer
//	@OneToMany(mappedBy = "student")
//	@JsonIgnoreProperties("student")
//	private List<StockTransfer> stockTransfers;

	// bi-directional many-to-one association to StudentAccount
	@OneToMany(mappedBy = "student")
	private List<StudentAccount> studentAccounts;

	// bi-directional many-to-one association to StudentDocument
	@OneToMany(mappedBy = "student")
	private List<StudentDocument> studentDocuments;

	// bi-directional many-to-one association to StudentGroupCollection
	@OneToMany(mappedBy = "student")
	private List<StudentGroupCollection> studentGroupCollections;

	// bi-directional many-to-one association to StudentQualification
	@OneToMany(mappedBy = "student")
	private List<StudentQualification> studentQualifications;

	// bi-directional many-to-one association to StudentRecord
	@OneToMany(mappedBy = "student")
	private List<StudentRecord> studentRecords;

	// bi-directional many-to-one association to StudentSibling
	@OneToMany(mappedBy = "student1")
	private List<StudentSibling> studentSiblings1;

	// bi-directional many-to-one association to StudentSibling
	@OneToMany(mappedBy = "student2")
	private List<StudentSibling> studentSiblings2;

	// bi-directional many-to-one association to BloodGroup
	@ManyToOne(targetEntity = BloodGroup.class)
	@JoinColumn(name = "blood_group_id")
	private BloodGroup bloodGroup;

	// bi-directional many-to-one association to Caste
	@ManyToOne(targetEntity = Caste.class)
	@JoinColumn(name = "caste_id")
	private Caste caste;

	// bi-directional many-to-one association to Category
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name = "category_id")
	private Category category;

	// bi-directional many-to-one association to Religion
	@ManyToOne(targetEntity = Religion.class)
	@JoinColumn(name = "religion_id")
	private Religion religion;

	// bi-directional many-to-one association to StudentParent
	@ManyToOne(targetEntity = StudentParent.class)
	@JoinColumn(name = "student_parent_id")
	private StudentParent studentParent;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to VisitorLog
	@OneToMany(mappedBy = "student")
	private List<VisitorLog> visitorLogs;

}
package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * The persistent class for the student_parents database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_parents")
public class StudentParent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "first_guardian_annual_income")
	private String firstGuardianAnnualIncome;

	@Column(name = "first_guardian_contact_number_1")
	private String firstGuardianContactNumber1;

	@Column(name = "first_guardian_contact_number_2")
	private String firstGuardianContactNumber2;

	@Temporal(TemporalType.DATE)
	@Column(name = "first_guardian_date_of_birth")
	private Date firstGuardianDateOfBirth;

	@Column(name = "first_guardian_email")
	private String firstGuardianEmail;

	@Column(name = "first_guardian_name")
	private String firstGuardianName;

	@Column(name = "first_guardian_occupation")
	private String firstGuardianOccupation;

	@Column(name = "first_guardian_photo")
	private String firstGuardianPhoto;

	@Column(name = "first_guardian_qualification")
	private String firstGuardianQualification;

	@Column(name = "first_guardian_relation")
	private String firstGuardianRelation;

	@Column(name = "first_guardian_unique_identification_number")
	private String firstGuardianUniqueIdentificationNumber;

	@Lob
	private String options;

	@Column(name = "second_guardian_annual_income")
	private String secondGuardianAnnualIncome;

	@Column(name = "second_guardian_contact_number_1")
	private String secondGuardianContactNumber1;

	@Column(name = "second_guardian_contact_number_2")
	private String secondGuardianContactNumber2;

	@Temporal(TemporalType.DATE)
	@Column(name = "second_guardian_date_of_birth")
	private Date secondGuardianDateOfBirth;

	@Column(name = "second_guardian_email")
	private String secondGuardianEmail;

	@Column(name = "second_guardian_name")
	private String secondGuardianName;

	@Column(name = "second_guardian_occupation")
	private String secondGuardianOccupation;

	@Column(name = "second_guardian_photo")
	private String secondGuardianPhoto;

	@Column(name = "second_guardian_qualification")
	private String secondGuardianQualification;

	@Column(name = "second_guardian_relation")
	private String secondGuardianRelation;

	@Column(name = "second_guardian_unique_identification_number")
	private String secondGuardianUniqueIdentificationNumber;

	@Column(name = "third_guardian_name")
	private String thirdGuardianName;

	@Column(name = "third_guardian_relation")
	private String thirdGuardianRelation;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	// bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "studentParent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Student> students;

}
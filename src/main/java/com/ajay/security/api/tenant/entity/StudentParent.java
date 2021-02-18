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
 * The persistent class for the student_parents database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_parents")
public class StudentParent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(name = "first_guardian_annual_income", length = 20)
	private String firstGuardianAnnualIncome;

	@Column(name = "first_guardian_contact_number_1", length = 20)
	private String firstGuardianContactNumber1;

	@Column(name = "first_guardian_contact_number_2", length = 20)
	private String firstGuardianContactNumber2;

	@Temporal(TemporalType.DATE)
	@Column(name = "first_guardian_date_of_birth")
	private Date firstGuardianDateOfBirth;

	@Column(name = "first_guardian_email", length = 30)
	private String firstGuardianEmail;

	@Column(name = "first_guardian_name", length = 50)
	private String firstGuardianName;

	@Column(name = "first_guardian_occupation", length = 20)
	private String firstGuardianOccupation;

	@Column(name = "first_guardian_photo")
	private String firstGuardianPhoto;

	@Column(name = "first_guardian_qualification", length = 20)
	private String firstGuardianQualification;

	@Column(name = "first_guardian_relation", length = 20)
	private String firstGuardianRelation;

	@Column(name = "first_guardian_unique_identification_number", length = 20)
	private String firstGuardianUniqueIdentificationNumber;

	@Column(length = 50)
	private String options;

	@Column(name = "second_guardian_annual_income", length = 20)
	private String secondGuardianAnnualIncome;

	@Column(name = "second_guardian_contact_number_1", length = 20)
	private String secondGuardianContactNumber1;

	@Column(name = "second_guardian_contact_number_2", length = 20)
	private String secondGuardianContactNumber2;

	@Temporal(TemporalType.DATE)
	@Column(name = "second_guardian_date_of_birth")
	private Date secondGuardianDateOfBirth;

	@Column(name = "second_guardian_email", length = 30)
	private String secondGuardianEmail;

	@Column(name = "second_guardian_name", length = 50)
	private String secondGuardianName;

	@Column(name = "second_guardian_occupation", length = 30)
	private String secondGuardianOccupation;

	@Column(name = "second_guardian_photo")
	private String secondGuardianPhoto;

	@Column(name = "second_guardian_qualification", length = 30)
	private String secondGuardianQualification;

	@Column(name = "second_guardian_relation", length = 30)
	private String secondGuardianRelation;

	@Column(name = "second_guardian_unique_identification_number", length = 30)
	private String secondGuardianUniqueIdentificationNumber;

	@Column(name = "third_guardian_name", length = 30)
	private String thirdGuardianName;

	@Column(name = "third_guardian_relation", length = 30)
	private String thirdGuardianRelation;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

//	// bi-directional many-to-one association to Student
//	@OneToMany(mappedBy = "studentParent")
//	private List<Student> students;

}
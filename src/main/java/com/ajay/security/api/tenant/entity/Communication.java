package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the communications database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "communications")
public class Communication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String audience;

	@Column(length = 50)
	private String body;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(name = "excluded_emails", length = 30)
	private String excludedEmails;

	@Column(name = "excluded_numbers", length = 20)
	private String excludedNumbers;

	@Column(name = "included_emails", length = 30)
	private String includedEmails;

	@Column(name = "included_numbers", length = 20)
	private String includedNumbers;

	@Column(length = 50)
	private String options;

	@Column(name = "recipient_count")
	private int recipientCount;

	@Column(name = "recipient_emails", length = 30)
	private String recipientEmails;

	@Column(name = "recipient_numbers", length = 20)
	private String recipientNumbers;

	@Column(length = 20)
	private String subject;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to CommunicationBatch
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationBatch.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationBatch> communicationBatches;

	// bi-directional many-to-one association to CommunicationCourse
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationCourse.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationCourse> communicationCourses;

	// bi-directional many-to-one association to CommunicationDepartment
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationDepartment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationDepartment> communicationDepartments;

	// bi-directional many-to-one association to CommunicationEmployee
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationEmployee.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationEmployee> communicationEmployees;

	// bi-directional many-to-one association to CommunicationEmployeeCategory
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationEmployeeCategory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationEmployeeCategory> communicationEmployeeCategories;

	// bi-directional many-to-one association to CommunicationStudentRecord
//	@OneToMany(mappedBy = "communication")
	@OneToMany(targetEntity = CommunicationStudentRecord.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "communication_id")
	private List<CommunicationStudentRecord> communicationStudentRecords;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = { "backups", "userPushTokens", "userPreferences", "uploads", "todos", "password",
			"postalRecords", "activationToken" })
	private User user;

}
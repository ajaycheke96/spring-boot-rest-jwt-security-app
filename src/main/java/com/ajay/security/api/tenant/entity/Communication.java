package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the communications database table.
 * 
 */
@Data
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

	@Lob
	@Column(length = 50)
	private String body;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	@Column(name = "excluded_emails", length = 30)
	private String excludedEmails;

	@Lob
	@Column(name = "excluded_numbers", length = 20)
	private String excludedNumbers;

	@Lob
	@Column(name = "included_emails", length = 30)
	private String includedEmails;

	@Lob
	@Column(name = "included_numbers", length = 20)
	private String includedNumbers;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(name = "recipient_count")
	private int recipientCount;

	@Lob
	@Column(name = "recipient_emails", length = 30)
	private String recipientEmails;

	@Lob
	@Column(name = "recipient_numbers", length = 20)
	private String recipientNumbers;

	@Column(length = 20)
	private String subject;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to CommunicationBatch
	@OneToMany(mappedBy = "communication")
	private List<CommunicationBatch> communicationBatches;

	// bi-directional many-to-one association to CommunicationCourse
	@OneToMany(mappedBy = "communication")
	private List<CommunicationCourse> communicationCourses;

	// bi-directional many-to-one association to CommunicationDepartment
	@OneToMany(mappedBy = "communication")
	private List<CommunicationDepartment> communicationDepartments;

	// bi-directional many-to-one association to CommunicationEmployee
	@OneToMany(mappedBy = "communication")
	private List<CommunicationEmployee> communicationEmployees;

	// bi-directional many-to-one association to CommunicationEmployeeCategory
	@OneToMany(mappedBy = "communication")
	private List<CommunicationEmployeeCategory> communicationEmployeeCategories;

	// bi-directional many-to-one association to CommunicationStudentRecord
	@OneToMany(mappedBy = "communication")
	private List<CommunicationStudentRecord> communicationStudentRecords;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}
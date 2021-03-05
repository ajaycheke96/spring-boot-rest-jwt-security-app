package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the visitor_logs database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "visitor_logs")
public class VisitorLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String address;

	@Column(name = "company_name", length = 50)
	private String companyName;

	@Column(name = "contact_number", length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_visit")
	private Date dateOfVisit;

	@Column(name = "entry_time")
	private Time entryTime;

	@Column(name = "exit_time")
	private Time exitTime;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "relation_with_student", length = 50)
	private String relationWithStudent;

	@Column(length = 50)
	private String remarks;

	@Column(length = 50)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	@Column(name = "visitor_count")
	private int visitorCount;

	// bi-directional many-to-one association to Employee
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	@JsonIgnoreProperties(value = { "payrolls", "incomes", "user", "religion", "category", "caste", "bloodGroup",
			"employeeSalaries", "employeeQualifications", "employeeDocuments", "employeeDesignations",
			"employeeAccounts", "certificates" })
	private Employee employee;

	// bi-directional many-to-one association to Student
	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id")
	@JsonIgnoreProperties({ "studentAccounts", "studentDocuments", "studentRecords", "studentParent", "user" })
	private Student student;

	// bi-directional many-to-one association to VisitingPurpos
	@ManyToOne(targetEntity = VisitingPurpose.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "visiting_purpose_id")
	private VisitingPurpose visitingPurpos;

}
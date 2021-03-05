package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * The persistent class for the book_logs database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_logs")
public class BookLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_issue")
	private Date dateOfIssue;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	@Lob
	@Column(name = "issue_remarks", length = 50)
	private String issueRemarks;

	@Column(name = "late_fee_applicable")
	private byte lateFeeApplicable;

	@Column(name = "late_fee_charge")
	private int lateFeeCharge;

	@Column(name = "late_fee_frequency", length = 50)
	private String lateFeeFrequency;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to BookLogDetail
//	@OneToMany(mappedBy = "bookLog")
	@OneToMany(targetEntity = BookLogDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_log_id")
	private List<BookLogDetail> bookLogDetails;

	// bi-directional many-to-one association to Employee
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	@JsonIgnoreProperties(value = { "payrolls", "incomes", "user", "religion", "category", "caste", "bloodGroup",
			"employeeSalaries", "employeeQualifications", "employeeDocuments", "employeeDesignations",
			"employeeAccounts", "certificates" })
	private Employee employee;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne(targetEntity = StudentRecord.class)
	@JoinColumn(name = "student_record_id")
	@JsonIgnoreProperties({ "certificates", "incomes", "onlineExamRecords", "studentFeeRecords", "feeAllocation",
			"admission", "transferCertificates", "transportRouteStudents" })
	private StudentRecord studentRecord;

}
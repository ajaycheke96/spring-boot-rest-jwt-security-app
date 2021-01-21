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
 * The persistent class for the student_records database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_records")
public class StudentRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_entry")
	private Date dateOfEntry;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_exit")
	private Date dateOfExit;

	@Column(name = "entry_remarks", length = 50)
	private String entryRemarks;

	@Column(name = "exit_remarks", length = 50)
	private String exitRemarks;

	@Column(name = "is_promoted")
	private byte isPromoted;

	@Column(length = 50)
	private String options;

	@Column(name = "roll_number", length = 20)
	private String rollNumber;

	@Column(name = "termination_reason", length = 50)
	private String terminationReason;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to BookLog
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BookLog> bookLogs;

	// bi-directional many-to-one association to Certificate
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Certificate> certificates;

	// bi-directional many-to-one association to CommunicationStudentRecord
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommunicationStudentRecord> communicationStudentRecords;

	// bi-directional many-to-one association to Expens
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Expense> expenses;

	// bi-directional many-to-one association to Income
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Income> incomes;

	// bi-directional many-to-one association to MeetingStudentRecord
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MeetingStudentRecord> meetingStudentRecords;

	// bi-directional many-to-one association to OnlineExamRecord
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OnlineExamRecord> onlineExamRecords;

	// bi-directional many-to-one association to StudentFeeRecord
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StudentFeeRecord> studentFeeRecords;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to Admission
	@ManyToOne
	private Admission admission;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

	// bi-directional many-to-one association to FeeAllocation
	@ManyToOne
	@JoinColumn(name = "fee_allocation_id")
	private FeeAllocation feeAllocation;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	// bi-directional many-to-one association to TransferCertificate
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TransferCertificate> transferCertificates;

	// bi-directional many-to-one association to TransportRouteStudent
	@OneToMany(mappedBy = "studentRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TransportRouteStudent> transportRouteStudents;

}
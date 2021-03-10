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
 * The persistent class for the student_records database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

//	// bi-directional many-to-one association to BookLog
//	@OneToMany(mappedBy = "studentRecord")
//	private List<BookLog> bookLogs;

	// bi-directional many-to-one association to Certificate
//	@OneToMany(mappedBy = "studentRecord")
	@OneToMany(targetEntity = Certificate.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_id")
	private List<Certificate> certificates;

//	// bi-directional many-to-one association to CommunicationStudentRecord
//	@OneToMany(mappedBy = "studentRecord")
//	private List<CommunicationStudentRecord> communicationStudentRecords;

//	// bi-directional many-to-one association to Expens
//	@OneToMany(mappedBy = "studentRecord")
//	private List<Expense> expenses;

	// bi-directional many-to-one association to Income
//	@OneToMany(mappedBy = "studentRecord")
	@OneToMany(targetEntity = Income.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_id")
//	@JsonIgnoreProperties({"transactionCategory", "user", "transactions"})
	private List<Income> incomes;

//	// bi-directional many-to-one association to MeetingStudentRecord
//	@OneToMany(mappedBy = "studentRecord")
//	private List<MeetingStudentRecord> meetingStudentRecords;

	// bi-directional many-to-one association to OnlineExamRecord
	@OneToMany(mappedBy = "studentRecord")
//	@OneToMany(targetEntity = OnlineExamRecord.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_record_id")
	@JsonIgnoreProperties({"studentRecord", ""})
	private List<OnlineExamRecord> onlineExamRecords;

	// bi-directional many-to-one association to StudentFeeRecord
//	@OneToMany(mappedBy = "studentRecord")
	@OneToMany(targetEntity = StudentFeeRecord.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_id")
	private List<StudentFeeRecord> studentFeeRecords;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne(targetEntity = AcademicSession.class)
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to Admission
	@ManyToOne(targetEntity = Admission.class)
	@JoinColumn(name = "admission_id")
	private Admission admission;

	// bi-directional many-to-one association to Batch
	@ManyToOne(targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;

	// bi-directional many-to-one association to FeeAllocation
	@ManyToOne(targetEntity = FeeAllocation.class)
	@JoinColumn(name = "fee_allocation_id")
	private FeeAllocation feeAllocation;

//	// bi-directional many-to-one association to Student
//	@ManyToOne
//	private Student student;

	// bi-directional many-to-one association to TransferCertificate
//	@OneToMany(mappedBy = "studentRecord")
	@OneToMany(targetEntity = TransferCertificate.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_id")
	private List<TransferCertificate> transferCertificates;

	// bi-directional many-to-one association to TransportRouteStudent
//	@OneToMany(mappedBy = "studentRecord")
	@OneToMany(targetEntity = TransportRouteStudent.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_id")
	private List<TransportRouteStudent> transportRouteStudents;

}
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the student_fee_records database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_fee_records")
public class StudentFeeRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "late_fee", length = 10)
	private int lateFee;

	@Column(name = "late_fee_applicable", length = 10)
	private int lateFeeApplicable;

	@Column(name = "late_fee_charged", length = 10)
	private int lateFeeCharged;

	@Column(name = "late_fee_frequency", length = 20)
	private String lateFeeFrequency;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String remarks;

	@Column(length = 20)
	private String status;

	@Column(name = "transport_fee", length = 10)
	private int transportFee;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to StudentFeeRecordDetail
//	@OneToMany(mappedBy = "studentFeeRecord", cascade = CascadeType.ALL)
	@OneToMany(targetEntity = StudentFeeRecordDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_fee_record_id")
	private List<StudentFeeRecordDetail> studentFeeRecordDetails;

	// bi-directional many-to-one association to FeeConcession
	@ManyToOne(targetEntity = FeeConcession.class)
	@JoinColumn(name = "fee_concession_id")
	private FeeConcession feeConcession;

	// bi-directional many-to-one association to FeeInstallment
	@ManyToOne(targetEntity = FeeInstallment.class)
	@JoinColumn(name = "fee_installment_id")
	private FeeInstallment feeInstallment;

//	// bi-directional many-to-one association to StudentRecord
//	@ManyToOne
//	@JoinColumn(name = "student_record_id")
//	private StudentRecord studentRecord;

	// bi-directional many-to-one association to TransportCircle
	@ManyToOne(targetEntity = TransportCircle.class)
	@JoinColumn(name = "transport_circle_id")
	private TransportCircle transportCircle;

	// bi-directional many-to-one association to StudentOptionalFeeRecord
//	@OneToMany(mappedBy = "studentFeeRecord")
	@OneToMany(targetEntity = StudentOptionalFeeRecord.class)
	@JoinColumn(name = "student_fee_record_id")
	private List<StudentOptionalFeeRecord> studentOptionalFeeRecords;

	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "studentFeeRecord")
	@OneToMany(targetEntity = Transaction.class)
	@JoinColumn(name = "student_fee_record_id")
	private List<Transaction> transactions;

}
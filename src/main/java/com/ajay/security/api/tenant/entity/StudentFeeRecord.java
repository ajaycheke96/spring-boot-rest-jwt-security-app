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
 * The persistent class for the student_fee_records database table.
 * 
 */
@Data
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
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to StudentFeeRecordDetail
	@OneToMany(mappedBy = "studentFeeRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StudentFeeRecordDetail> studentFeeRecordDetails;

	// bi-directional many-to-one association to FeeConcession
	@ManyToOne
	@JoinColumn(name = "fee_concession_id")
	private FeeConcession feeConcession;

	// bi-directional many-to-one association to FeeInstallment
	@ManyToOne
	@JoinColumn(name = "fee_installment_id")
	private FeeInstallment feeInstallment;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne
	@JoinColumn(name = "student_record_id")
	private StudentRecord studentRecord;

	// bi-directional many-to-one association to TransportCircle
	@ManyToOne
	@JoinColumn(name = "transport_circle_id")
	private TransportCircle transportCircle;

	// bi-directional many-to-one association to StudentOptionalFeeRecord
	@OneToMany(mappedBy = "studentFeeRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StudentOptionalFeeRecord> studentOptionalFeeRecords;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "studentFeeRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}
package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * The persistent class for the transactions database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private BigDecimal amount;

	@Lob
	@Column(name = "cancellation_remarks")
	private String cancellationRemarks;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cancelled_at")
	private Date cancelledAt;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_reconciliation")
	private Date dateOfReconciliation;

	@Column(name = "gateway_token")
	private String gatewayToken;

	@Column(name = "handling_fee")
	private BigDecimal handlingFee;

	private String head;

	@Column(name = "instrument_bank_detail")
	private String instrumentBankDetail;

	@Temporal(TemporalType.DATE)
	@Column(name = "instrument_clearing_date")
	private Date instrumentClearingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "instrument_date")
	private Date instrumentDate;

	@Column(name = "instrument_number")
	private String instrumentNumber;

	@Column(name = "is_advance_salary")
	private byte isAdvanceSalary;

	@Column(name = "is_cancelled")
	private byte isCancelled;

	@Column(name = "is_online_payment")
	private byte isOnlinePayment;

	private int number;

	@Lob
	private String options;

	private String prefix;

	@Column(name = "reference_number")
	private String referenceNumber;

	@Lob
	private String remarks;

	private String source;

	@Column(name = "source_detail")
	private String sourceDetail;

	private byte type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	private String uuid;

	// bi-directional many-to-one association to StudentFeeRecordDetail
	@OneToMany(mappedBy = "transaction",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentFeeRecordDetail> studentFeeRecordDetails;

	// bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	// bi-directional many-to-one association to AccountTransfer
	@ManyToOne
	@JoinColumn(name = "account_transfer_id")
	private AccountTransfer accountTransfer;

	// bi-directional many-to-one association to Bill
	@ManyToOne
	private Bill bill;

	// bi-directional many-to-one association to BookLogDetail
	@ManyToOne
	@JoinColumn(name = "book_log_detail_id")
	private BookLogDetail bookLogDetail;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to Expens
	@ManyToOne
	@JoinColumn(name = "expense_id")
	private Expense expens;

	// bi-directional many-to-one association to Income
	@ManyToOne
	private Income income;

	// bi-directional many-to-one association to PaymentMethod
	@ManyToOne
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	// bi-directional many-to-one association to Payroll
	@ManyToOne
	private Payroll payroll;

	// bi-directional many-to-one association to Registration
	@ManyToOne
	private Registration registration;

	// bi-directional many-to-one association to StudentFeeRecord
	@ManyToOne
	@JoinColumn(name = "student_fee_record_id")
	private StudentFeeRecord studentFeeRecord;

	// bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name = "transaction_group_id")
	private Transaction transaction;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "transaction")
	private List<Transaction> transactions;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}
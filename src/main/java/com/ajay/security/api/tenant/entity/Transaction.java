package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the transactions database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private BigDecimal amount;

	@Lob
	@Column(name = "cancellation_remarks", length = 30)
	private String cancellationRemarks;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cancelled_at")
	private Date cancelledAt;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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

	@Column(length = 50)
	private String head;

	@Column(name = "instrument_bank_detail", length = 50)
	private String instrumentBankDetail;

	@Temporal(TemporalType.DATE)
	@Column(name = "instrument_clearing_date")
	private Date instrumentClearingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "instrument_date")
	private Date instrumentDate;

	@Column(name = "instrument_number", length = 50)
	private String instrumentNumber;

	@Column(name = "is_advance_salary")
	private byte isAdvanceSalary;

	@Column(name = "is_cancelled")
	private byte isCancelled;

	@Column(name = "is_online_payment")
	private byte isOnlinePayment;

	private int number;

	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private String prefix;

	@Column(name = "reference_number", length = 50)
	private String referenceNumber;

	@Column(length = 50)
	private String remarks;

	@Column(length = 50)
	private String source;

	@Column(name = "source_detail", length = 50)
	private String sourceDetail;

	private byte type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to StudentFeeRecordDetail
	@OneToMany(mappedBy = "transaction")
	@JsonIgnore
//	@JsonIgnoreProperties("transaction")
	private List<StudentFeeRecordDetail> studentFeeRecordDetails;

	// bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Account account;

	// bi-directional many-to-one association to AccountTransfer
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	@JoinColumn(name = "account_transfer_id")
	private AccountTransfer accountTransfer;

	// bi-directional many-to-one association to Bill
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Bill bill;

	// bi-directional many-to-one association to BookLogDetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_log_detail_id")
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private BookLogDetail bookLogDetail;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Employee employee;

	// bi-directional many-to-one association to Expens
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	@JoinColumn(name = "expense_id")
	private Expense expens;

	// bi-directional many-to-one association to Income
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Income income;

	// bi-directional many-to-one association to PaymentMethod
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_method_id")
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private PaymentMethod paymentMethod;

	// bi-directional many-to-one association to Payroll
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Payroll payroll;

	// bi-directional many-to-one association to Registration
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Registration registration;

	// bi-directional many-to-one association to StudentFeeRecord
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_fee_record_id")
	@JsonIgnore
//	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private StudentFeeRecord studentFeeRecord;

	// bi-directional many-to-one association to Transaction
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_group_id")
//	@JsonIgnore
	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private Transaction transaction;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "transaction")
//	@JsonIgnore
	@JsonIgnoreProperties(value = { "transaction" })
	private List<Transaction> transactions;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties(value = { "transactions", "hibernateLazyInitializer" })
	private User user;

}
package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
 * The persistent class for the expenses database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "expenses")
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private BigDecimal amount;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_expense")
	private Date dateOfExpense;

	@Column(length = 50)
	private String description;

	@Column(name = "is_cancelled")
	private byte isCancelled;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token",length = 50)
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to Employee
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	// bi-directional many-to-one association to StudentRecord
	@ManyToOne(targetEntity = StudentRecord.class)
	@JoinColumn(name = "student_record_id")
	private StudentRecord studentRecord;

	// bi-directional many-to-one association to TransactionCategory
	@ManyToOne(targetEntity = TransactionCategory.class)
	@JoinColumn(name = "transaction_category_id")
	private TransactionCategory transactionCategory;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to Vendor
	@ManyToOne(targetEntity = Vendor.class)
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "expens")
	@OneToMany(targetEntity = Transaction.class)
	@JoinColumn(name = "expense_id")
	private List<Transaction> transactions;

}
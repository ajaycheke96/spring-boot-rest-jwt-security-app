package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the incomes database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "incomes")
public class Income implements Serializable {
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
	@Column(name = "date_of_income")
	private Date dateOfIncome;

	@Column(length = 50)
	private String description;

	@Column(name = "is_cancelled")
	private byte isCancelled;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to Employee
//	@ManyToOne
//	private Employee employee;

//	// bi-directional many-to-one association to StudentRecord
//	@ManyToOne(targetEntity = StudentRecord.class)
//	@JoinColumn(name = "student_record_id")
//	private StudentRecord studentRecord;

	// bi-directional many-to-one association to TransactionCategory
	@ManyToOne(targetEntity = TransactionCategory.class)
	@JoinColumn(name = "transaction_category_id")
	private TransactionCategory transactionCategory;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({ "userPushTokens", "userPreferences", "uploads", "todos", "postalRecords", "backups",
			"password" })
	private User user;

	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "income")
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "income_id")
	private List<Transaction> transactions;

}
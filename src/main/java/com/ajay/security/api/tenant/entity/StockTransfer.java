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
 * The persistent class for the stock_transfers database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock_transfers")
public class StockTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	private Date returnDate;

	@Column(name = "return_description", length = 50)
	private String returnDescription;

	@Temporal(TemporalType.DATE)
	@Column(name = "return_due_date")
	private Date returnDueDate;

	@Column(name = "return_status", length = 50)
	private String returnStatus;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to StockTransferDetail
//	@OneToMany(mappedBy = "stockTransfer")
	@OneToMany(targetEntity = StockTransferDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_transfer_id")
	private List<StockTransferDetail> stockTransferDetails;

//	// bi-directional many-to-one association to StockTransferReturn
//	@OneToMany(mappedBy = "stockTransfer")
//	@JsonIgnoreProperties("stockTransfer")
//	private List<StockTransferReturn> stockTransferReturns;

	// bi-directional many-to-one association to Employee
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	@JsonIgnoreProperties(value = { "payrolls", "incomes", "user", "religion", "category", "caste", "bloodGroup",
			"employeeSalaries", "employeeQualifications", "employeeDocuments", "employeeDesignations",
			"employeeAccounts", "certificates" })
	private Employee employee;

	// bi-directional many-to-one association to Room
	@ManyToOne(targetEntity = Room.class)
	@JoinColumn(name = "room_id")
	private Room room;

	// bi-directional many-to-one association to Student
	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id")
	@JsonIgnoreProperties({ "studentAccounts", "studentDocuments", "studentRecords", "user" })
	private Student student;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = { "backups", "userPushTokens", "userPreferences", "uploads", "todos", "password",
			"postalRecords", "activationToken" })
	private User user;

}
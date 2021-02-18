package com.ajay.security.api.tenant.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users_2")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 50)
	private String username;

	private String password;

	@Column(length = 50)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Column(name = "activation_token")
	private String activationToken;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	private byte enabled;

	@Column(name = "remember_token")
	private String rememberToken;

	@Column(length = 20)
	private String status;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to AccountTransfer
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<AccountTransfer> accountTransfers;

//	// bi-directional many-to-one association to Article
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Article> articles;

	// bi-directional many-to-one association to Backup
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<Backup> backups;

//	// bi-directional many-to-one association to CallLog
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<CallLog> callLogs;

//	// bi-directional many-to-one association to Communication
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Communication> communications;

//	// bi-directional many-to-one association to Complaint
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Complaint> complaints;

//	// bi-directional many-to-one association to EmployeeLeaveRequestDetail
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<EmployeeLeaveRequestDetail> employeeLeaveRequestDetails;

//	// bi-directional many-to-one association to EmployeeLeaveRequest
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<EmployeeLeaveRequest> employeeLeaveRequests;

//	// bi-directional many-to-one association to Employee
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Employee> employees;

//	// bi-directional many-to-one association to Enquiry
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Enquiry> enquiries;

//	// bi-directional many-to-one association to EnquiryFollowUp
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<EnquiryFollowUp> enquiryFollowUps;

//	// bi-directional many-to-one association to Event
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Event> events;

//	// bi-directional many-to-one association to Expens
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Expense> expenses;

//	// bi-directional many-to-one association to GatePass
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<GatePass> gatePasses;

//	// bi-directional many-to-one association to Income
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Income> incomes;

//	// bi-directional many-to-one association to Meeting
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Meeting> meetings;

	// bi-directional many-to-one association to PostalRecord
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<PostalRecord> postalRecords;

//	// bi-directional many-to-one association to StockPurchas
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<StockPurchase> stockPurchases;

//	// bi-directional many-to-one association to StockTransferReturn
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<StockTransferReturn> stockTransferReturns;

//	// bi-directional many-to-one association to StockTransfer
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<StockTransfer> stockTransfers;

//	// bi-directional many-to-one association to StudentParent
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<StudentParent> studentParents;

//	// bi-directional many-to-one association to Student
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Student> students;

	// bi-directional many-to-one association to Todo
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<Todo> todos;

//	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "user")
//	@JsonIgnoreProperties("user")
//	private List<Transaction> transactions;

	// bi-directional many-to-one association to Upload
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<Upload> uploads;

	// bi-directional many-to-one association to UserPreference
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties({"user", "academicSession"})
	private List<UserPreference> userPreferences;

	// bi-directional many-to-one association to UserPushToken
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<UserPushToken> userPushTokens;
}

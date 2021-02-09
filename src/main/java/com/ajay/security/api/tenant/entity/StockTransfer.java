package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@OneToMany(mappedBy = "stockTransfer")
	@JsonIgnoreProperties("stockTransfer")
	private List<StockTransferDetail> stockTransferDetails;

	// bi-directional many-to-one association to StockTransferReturn
	@OneToMany(mappedBy = "stockTransfer")
	@JsonIgnoreProperties("stockTransfer")
	private List<StockTransferReturn> stockTransferReturns;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties(value = { "stockTransfers", "hibernateLazyInitializer" })
	private Employee employee;

	// bi-directional many-to-one association to Room
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = { "stockTransfers", "hibernateLazyInitializer" })
	private Room room;

	// bi-directional many-to-one association to Student
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties(value = { "stockTransfers", "hibernateLazyInitializer" })
	private Student student;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties(value = { "stockTransfers", "hibernateLazyInitializer" })
	private User user;

}
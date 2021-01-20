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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the stock_transfers database table.
 * 
 */
@Data
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
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to StockTransferDetail
	@OneToMany(mappedBy = "stockTransfer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockTransferDetail> stockTransferDetails;

	// bi-directional many-to-one association to StockTransferReturn
	@OneToMany(mappedBy = "stockTransfer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StockTransferReturn> stockTransferReturns;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to Room
	@ManyToOne
	private Room room;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}
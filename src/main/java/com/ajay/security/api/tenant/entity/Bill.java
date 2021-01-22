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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the bills database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bills")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "bill_number", length = 30)
	private String billNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Lob
	@Column(length = 50)
	private String description;

	@Lob
	@Column(length = 40)
	private String memo;

	@Temporal(TemporalType.DATE)
	@Column(name = "next_service_date")
	private Date nextServiceDate;

	@Lob
	@Column(length = 40)
	private String options;

	@Column(name = "reference_number",length = 30)
	private String referenceNumber;

	@Lob
	@Column(length = 20)
	private String subject;

	@Column(name = "subtotal_discount")
	private BigDecimal subtotalDiscount;

	@Column(name = "subtotal_handling")
	private BigDecimal subtotalHandling;

	@Column(name = "subtotal_tax")
	private BigDecimal subtotalTax;

	@Column(name = "subtotal_total")
	private BigDecimal subtotalTotal;

	@Lob
	@Column(length = 30)
	private String tnc;
	
	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token", length = 50)
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to BillItem
	@OneToMany(mappedBy = "bill",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BillItem> billItems;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle1;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vehicle vehicle2;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "bill",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}
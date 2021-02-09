package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the vendors database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vendors")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "address_line_1", length = 50)
	private String addressLine1;

	@Column(name = "address_line_2", length = 50)
	private String addressLine2;

	@Column(name = "alternate_phone", length = 20)
	private String alternatePhone;

	@Column(length = 20)
	private String city;

	@Column(name = "contact_person", length = 50)
	private String contactPerson;

	@Column(name = "contact_person_email", length = 50)
	private String contactPersonEmail;

	@Column(name = "contact_person_phone", length = 50)
	private String contactPersonPhone;

	@Column(length = 20)
	private String country;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String email;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private String phone;

	@Column(length = 20)
	private String state;

	@Column(name = "tax_id")
	private String taxId;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 20)
	private String zipcode;

	// bi-directional many-to-one association to Expens
	@OneToMany(mappedBy = "vendor")
	@JsonIgnoreProperties("vendor")
	private List<Expense> expenses;

	// bi-directional many-to-one association to StockPurchas
	@OneToMany(mappedBy = "vendor")
	@JsonIgnoreProperties("vendor")
	private List<StockPurchase> stockPurchases;

	// bi-directional many-to-one association to VendorAccount
	@OneToMany(mappedBy = "vendor")
	@JsonIgnoreProperties("vendor")
	private List<VendorAccount> vendorAccounts;

}
package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the accounts database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "account_number", length = 30)
	private String accountNumber;

	@Column(name = "bank_identification_code", length = 30)
	private String bankIdentificationCode;

	@Column(name = "bank_name", length = 30)
	private String bankName;

	@Column(name = "branch_name", length = 30)
	private String branchName;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_active")
	private byte isActive;

	@Column(length = 20)
	private String name;

	@Column(name = "opening_balance")
	private BigDecimal openingBalance;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private String prefix;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to AccountTransfer
	@OneToMany(mappedBy = "account1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AccountTransfer> accountTransfers1;

	// bi-directional many-to-one association to AccountTransfer
	@OneToMany(mappedBy = "account2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AccountTransfer> accountTransfers2;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}
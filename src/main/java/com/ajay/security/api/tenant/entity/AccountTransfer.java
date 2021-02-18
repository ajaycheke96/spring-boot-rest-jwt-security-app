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
import javax.persistence.Lob;
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
 * The persistent class for the account_transfers database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "account_transfers")
public class AccountTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private BigDecimal amount;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_account_transfer")
	private Date dateOfAccountTransfer;

	@Lob
	@Column(length = 50)
	private String description;

	@Column(name = "is_cancelled")
	private byte isCancelled;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token", length = 50)
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to Account
	@ManyToOne(targetEntity = Account.class)
	@JoinColumn(name = "from_account_id")
	private Account account1;

	// bi-directional many-to-one association to Account
	@ManyToOne(targetEntity = Account.class)
	@JoinColumn(name = "to_account_id")
	private Account account2;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "accountTransfer", fetch = FetchType.LAZY)
	@OneToMany(targetEntity = Transaction.class)
	@JoinColumn(name = "account_transfer_id")
	private List<Transaction> transactions;

}
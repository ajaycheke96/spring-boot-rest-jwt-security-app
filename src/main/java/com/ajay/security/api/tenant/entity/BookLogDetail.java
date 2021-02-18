package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the book_log_details database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_log_details")
public class BookLogDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_return")
	private Date dateOfReturn;

	@Column(name = "is_non_returnable")
	private byte isNonReturnable;

	@Column(name = "late_fee", length = 20)
	private int lateFee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "non_returnable_at")
	private Date nonReturnableAt;

	@Column(name = "non_returnable_charge", length = 20)
	private String nonReturnableCharge;

	@Column(name = "non_returnable_remarks", length = 20)
	private String nonReturnableRemarks;

	@Column(length = 50)
	private String options;

	@Column(name = "return_remarks", length = 20)
	private String returnRemarks;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to BookLog
//	@ManyToOne
//	@JoinColumn(name = "book_log_id")
//	private BookLog bookLog;

	// bi-directional many-to-one association to BookPostDetail
	@ManyToOne
	@JoinColumn(name = "book_post_detail_id")
	@JsonIgnoreProperties({ "bookLogDetails", "bookCondition" })
	private BookPostDetail bookPostDetail;

	// bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy = "bookLogDetail")
	@OneToMany(targetEntity = Transaction.class)
	@JoinColumn(name = "book_log_detail_id")
	private List<Transaction> transactions;

}
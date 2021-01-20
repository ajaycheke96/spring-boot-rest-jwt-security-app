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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the book_log_details database table.
 * 
 */
@Data
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

	@Lob
	@Column(name = "non_returnable_charge", length = 20)
	private String nonReturnableCharge;

	@Lob
	@Column(name = "non_returnable_remarks", length = 20)
	private String nonReturnableRemarks;

	@Lob
	@Column(length = 50)
	private String options;

	@Lob
	@Column(name = "return_remarks", length = 20)
	private String returnRemarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BookLog
	@ManyToOne
	@JoinColumn(name = "book_log_id")
	private BookLog bookLog;

	// bi-directional many-to-one association to BookPostDetail
	@ManyToOne
	@JoinColumn(name = "book_post_detail_id")
	private BookPostDetail bookPostDetail;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "bookLogDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Transaction> transactions;

}
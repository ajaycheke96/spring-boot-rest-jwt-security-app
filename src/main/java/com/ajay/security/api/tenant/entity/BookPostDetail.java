package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the book_post_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_post_details")
public class BookPostDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_not_available")
	private byte isNotAvailable;

	@Column(length = 20)
	private String location;

	private BigInteger number;

	@Lob
	@Column(length = 50)
	private String options;

	@Lob
	@Column(length = 30)
	private String remarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BookLogDetail
	@OneToMany(mappedBy = "bookPostDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BookLogDetail> bookLogDetails;

	// bi-directional many-to-one association to BookCondition
	@ManyToOne
	@JoinColumn(name = "book_condition_id")
	private BookCondition bookCondition;

	// bi-directional many-to-one association to BookPost
	@ManyToOne
	@JoinColumn(name = "book_post_id")
	private BookPost bookPost;

}
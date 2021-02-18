package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the book_post_details database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BookLogDetail
	@OneToMany(mappedBy = "bookPostDetail")
	@JsonIgnoreProperties({ "bookPostDetail", "transactions" })
	private List<BookLogDetail> bookLogDetails;

	// bi-directional many-to-one association to BookCondition
	@ManyToOne(targetEntity = BookCondition.class)
	@JoinColumn(name = "book_condition_id")
	private BookCondition bookCondition;

//	// bi-directional many-to-one association to BookPost
//	@ManyToOne
//	@JoinColumn(name = "book_post_id")
//	private BookPost bookPost;

}
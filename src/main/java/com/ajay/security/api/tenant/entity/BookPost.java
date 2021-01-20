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
 * The persistent class for the book_posts database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_posts")
public class BookPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_addition")
	private Date dateOfAddition;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int quantity;

	@Lob
	@Column(length = 30)
	private String remarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to BookPostDetail
	@OneToMany(mappedBy = "bookPost",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BookPostDetail> bookPostDetails;

	// bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

}
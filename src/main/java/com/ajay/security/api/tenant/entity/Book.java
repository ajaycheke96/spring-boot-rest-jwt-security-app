package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * The persistent class for the books database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "books")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String edition;

	@Column(name = "isbn_number", length = 50)
	private String isbnNumber;

	@Column(length = 50)
	private String options;

	@Column(length = 10)
	private int page;

	@Column(length = 10)
	private int price;

	@Column(length = 50)
	private String summary;

	@Column(length = 30)
	private String title;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to BookPost
//	@OneToMany(mappedBy = "book")
	@OneToMany(targetEntity = BookPost.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private List<BookPost> bookPosts;

	// bi-directional many-to-one association to BookAuthor
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "book_author_id")
	@JsonIgnoreProperties("books")
	private BookAuthor bookAuthor;

	// bi-directional many-to-one association to BookLanguage
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "book_language_id")
	@JsonIgnoreProperties("books")
	private BookLanguage bookLanguage;

	// bi-directional many-to-one association to BookPublisher
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "book_publisher_id")
	@JsonIgnoreProperties("books")
	private BookPublisher bookPublisher;

	// bi-directional many-to-one association to BookTopic
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_topic_id")
	@JsonIgnoreProperties("books")
	private BookTopic bookTopic;

}
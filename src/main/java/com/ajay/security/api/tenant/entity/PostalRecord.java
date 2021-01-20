package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the postal_records database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "postal_records")
public class PostalRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(name = "is_confidential")
	private byte isConfidential;

	@Column(length = 50)
	private String options;

	@Lob
	@Column(name = "receiver_address", length = 100)
	private String receiverAddress;

	@Column(name = "receiver_title", length = 50)
	private String receiverTitle;

	@Column(name = "reference_number", length = 50)
	private String referenceNumber;

	@Lob
	@Column(name = "sender_address", length = 100)
	private String senderAddress;

	@Column(name = "sender_title", length = 50)
	private String senderTitle;

	@Column(length = 50)
	private String type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}
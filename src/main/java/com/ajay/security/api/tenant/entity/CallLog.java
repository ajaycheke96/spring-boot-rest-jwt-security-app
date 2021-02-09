package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the call_logs database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "call_logs")
public class CallLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	private Date date;

	@Column(length = 50)
	private String description;

	@Column(name = "end_time")
	private Time endTime;

	@Column(name = "incoming_number", length = 20)
	private String incomingNumber;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "outgoing_number", length = 20)
	private String outgoingNumber;

	@Column(name = "start_time")
	private Time startTime;

	@Column(length = 20)
	private String type;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token", length = 50)
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to CallingPurpos
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "calling_purpose_id")
	@JsonIgnoreProperties({ "callLogs", "hibernateLazyInitializer" })
	private CallingPurpos callingPurpos;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	@JsonIgnoreProperties({ "callLogs", "hibernateLazyInitializer" })
	private User user;

}
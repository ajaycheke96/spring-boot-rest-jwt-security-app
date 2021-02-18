package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the todos database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "todos")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "completed_at")
	private Date completedAt;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	private byte status;

	@Column(length = 20)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JsonIgnoreProperties({ "todos" })
	private User user;

}
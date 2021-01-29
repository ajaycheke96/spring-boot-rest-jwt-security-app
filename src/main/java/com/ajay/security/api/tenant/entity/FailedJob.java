package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the failed_jobs database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "failed_jobs")
public class FailedJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	private String connection;

	private String exception;

	@Column(name = "failed_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp failedAt;

	private String payload;

	private String queue;

}
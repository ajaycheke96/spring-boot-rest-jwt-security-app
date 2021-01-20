package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transport_fee_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transport_fee_details")
public class TransportFeeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int amount;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to TransportCircle
	@ManyToOne
	@JoinColumn(name = "transport_circle_id")
	private TransportCircle transportCircle;

	// bi-directional many-to-one association to TransportFee
	@ManyToOne
	@JoinColumn(name = "transport_fee_id")
	private TransportFee transportFee;

}